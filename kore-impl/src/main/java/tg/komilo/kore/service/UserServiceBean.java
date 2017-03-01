/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import tg.komilo.kore.dao.GenericDAOBeanLocal;
import tg.komilo.kore.dao.PermissionDAOBeanLocal;
import tg.komilo.kore.dao.RoleDAOBeanLocal;
import tg.komilo.kore.dao.UserDAOBeanLocal;
import tg.komilo.kore.entities.Permission;
import tg.komilo.kore.entities.Role;
import tg.komilo.kore.entities.User;
import tg.komilo.kore.utils.KoreConstants;
import tg.komilo.kore.utils.SortDirection;
import tg.komilo.kore.utils.SortParams;

/**
 *
 * @author persistence
 */
@Stateless
public class UserServiceBean extends GenericServiceBean<User, Long>
        implements UserServiceBeanRemote {

    @EJB
    private UserDAOBeanLocal dao;

    @EJB
    private RoleDAOBeanLocal roleDAO;

    @EJB
    private PermissionDAOBeanLocal permissionDAO;

    @EJB
    private UserSessionServiceBeanRemote userSessionService;

    @Override
    protected GenericDAOBeanLocal<User, Long> getDAO() {
        return this.dao;
    }

    @Override
    public void addOne(User e) {
        this.saltPassword(e);
        super.addOne(e);
    }

    @Override
    public User updateOne(User e) {
        if (e.getPassword().isEmpty()) {
            e.setPassword(this.dao.getPassword(e.getId()));
        } else {
            this.saltPassword(e);
        }
        return super.updateOne(e);
    }

    @Override
    public User getOne(Long id) {
        User user = super.getOne(id);
        user.getRoles().isEmpty();
        return user;
    }

    private void saltPassword(User e) {
        String hash = new Sha256Hash(e.getPassword()).toHex();
        e.setPassword(hash);
    }

    @Override
    public Long getId(User e) {
        return e.getId();
    }

    @Override
    public User findByUsername(String username) {
        return this.dao.findByUsername(username);
    }

    @Override
    public List<Role> findRolesForUser(Long id) {
        return this.roleDAO.getAll(id, SortParams.from("label", SortDirection.ASCENDING));
    }

    @Override
    public List<Permission> findPermissionsForRole(Long roleId) {
        return this.permissionDAO.findByRole(roleId, SortParams.from("code", SortDirection.ASCENDING));
    }

    @Override
    public User getCurrent() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return this.dao.findByUsername(username);
    }

    @Override
    public String getClientIPAdress() {
        return SecurityUtils.getSubject().getSession().getHost();
    }

    @Override
    public boolean isPermitted(String permissionCode) {
        Subject subject = SecurityUtils.getSubject();
        return subject.isPermitted(permissionCode);
    }

    @Override
    public boolean isPermitted(Permission permission) {
        Subject subject = SecurityUtils.getSubject();
        return subject.isPermitted(permission.getCode());
    }

    @Override
    public boolean login(User user) {
        return this.login(user.getUsername(), user.getPassword(), false);
    }

    @Override
    public boolean login(String username, String password) {
        return this.login(username, password, false);
    }

    @Override
    public boolean login(String username, String password, boolean rememberMe) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            // initialisation d'un UserSession
            this.userSessionService.initSession(username);
            this.logService.info("Connexion de l'utilisateur.", KoreConstants.LOG_SECURITY);
            return true;
        } catch (AuthenticationException ae) {
//            this.logService.warn("Échec de la connexion: " + ae.getMessage(), KoreConstants.LOG_SECURITY);
            return false;
        }
    }

    @Override
    public void logout() {
        this.logService.info("Déconnexion de l'utilisateur.", KoreConstants.LOG_SECURITY);
        this.userSessionService.closeSession(this.getCurrent());
        System.out.println("-> Current:" + this.getCurrent());
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @Override
    public void logout(String token) {
        // TODO
        this.logService.info("Déconnexion de l'utilisateur avec le jeton " + token + ".", KoreConstants.LOG_SECURITY);
        this.userSessionService.closeSession(this.getCurrent());
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
