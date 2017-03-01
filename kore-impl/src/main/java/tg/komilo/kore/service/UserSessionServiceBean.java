/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.komilo.kore.dao.GenericDAOBeanLocal;
import tg.komilo.kore.dao.UserSessionDAOBeanLocal;
import tg.komilo.kore.entities.User;
import tg.komilo.kore.entities.UserSession;
import tg.komilo.kore.exception.BusinessException;

/**
 *
 * @author komilo
 */
@Stateless
public class UserSessionServiceBean extends GenericServiceBean<UserSession, Long>
        implements UserSessionServiceBeanRemote {

    @EJB
    private UserSessionDAOBeanLocal dao;

    @EJB
    private UserServiceBeanRemote userService;

    @Override
    protected GenericDAOBeanLocal<UserSession, Long> getDAO() {
        return this.dao;
    }

    @Override
    public Long getId(UserSession e) {
        return e.getId();
    }

    @Override
    public void initSession(User user) {
        this.initSession(user.getUsername());
    }

    @Override
    public void initSession(String username) {
        User user = this.userService.findByUsername(username);
        if (user == null) {
            throw new BusinessException("L'utilisateur '" + username + "' n'existe pas.");
        }
        UserSession session = new UserSession();
        session.setStartDate(new Date());
        session.setHost(this.userService.getClientIPAdress());
        session.setUser(user);
        session.setToken(UUID.randomUUID().toString());
        this.dao.addOne(session);
    }

    @Override
    public void closeSession(User user) {
        UserSession session = this.dao.getLastByUserId(user.getId());
        if (session == null) {
            this.logger.log(Level.WARNING, "Aucune session n'existe pour l'utilisateur ''{0}''.", 
                    user.getUsername());
        } else {
            session.setEndDate(new Date());
            this.dao.updateOne(session);
        }
    }

    @Override
    public boolean isTokenValid(String token) {
        return this.dao.isTokenValid(token);
    }

    @Override
    public String getToken(String username) {
        return this.dao.getToken(username);
    }

    @Override
    public UserSession getLast() {
        return this.getLast(this.userService.getCurrent());
    }

    @Override
    public UserSession getLast(String username) {
        return this.getLast(this.userService.findByUsername(username));
    }

    @Override
    public UserSession getLast(User user) {
        if (user == null) {
            return null;
        }
        return this.dao.getLastByUserId(user.getId());
    }
}
