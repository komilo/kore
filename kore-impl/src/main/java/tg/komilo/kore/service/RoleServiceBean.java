/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.komilo.kore.dao.GenericDAOBeanLocal;
import tg.komilo.kore.dao.RoleDAOBeanLocal;
import tg.komilo.kore.entities.Role;
import tg.komilo.kore.entities.User;
import tg.komilo.kore.utils.SortDirection;
import tg.komilo.kore.utils.SortParams;

/**
 *
 * @author persistence
 */
@Stateless
public class RoleServiceBean extends GenericServiceBean<Role, Long> 
        implements RoleServiceBeanRemote {
    
    @EJB
    private RoleDAOBeanLocal dao;

    @Override
    protected GenericDAOBeanLocal<Role, Long> getDAO() {
        return this.dao;
    }

    @Override
    public Long getId(Role e) {
        return e.getId();
    }

    @Override
    public List<Role> getAll(User user) {
        if (user == null) {
            return Collections.EMPTY_LIST;
        }
        return this.dao.getAll(user.getId(), SortParams.from("label", SortDirection.ASCENDING));
    }
  
}
