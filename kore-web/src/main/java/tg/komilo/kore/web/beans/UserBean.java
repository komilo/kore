/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.web.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tg.komilo.kore.entities.Role;
import tg.komilo.kore.entities.User;
import tg.komilo.kore.service.GenericServiceBeanRemote;
import tg.komilo.kore.service.RoleServiceBeanRemote;
import tg.komilo.kore.utils.KoreConstants;

/**
 *
 * @author komilo
 */
@ManagedBean
@ViewScoped
public class UserBean extends GenericBean<User, Long> {

    @EJB
    private RoleServiceBeanRemote roleService;

    private List<Role> roles;

    public UserBean() {
        super();
    }

    @PostConstruct
    @Override
    public void init() {
        super.init();
        this.entity = new User();
//        this.entity.getRoles().size();
        this.roles = this.roleService.getAll();
    }

    @Override
    public void initUpdate() {
        super.initUpdate();
        this.entity.setPassword("");
    }

    @Override
    public GenericServiceBeanRemote getService() {
        return this.userService;
    }

    public List<Role> getRoles(User user) {
        return this.roleService.getAll(user);
    }

    public List<Role> getRoles() {
        return this.roles;
    }

//    @Override
//    public String delete() {
//        System.out.println("-- Call to delete()!");
//        return "list?faces-redirect=true";
//    }
    @Override
    public boolean canAdd() {
        return this.userService.isPermitted(KoreConstants.PERM_SECURITY_USER_ADD);
    }

    @Override
    public boolean canUpdate() {
        return this.userService.isPermitted(KoreConstants.PERM_SECURITY_USER_EDIT);
    }

    @Override
    public boolean canDelete() {
        return this.userService.isPermitted(KoreConstants.PERM_SECURITY_USER_DELETE);
    }
}
