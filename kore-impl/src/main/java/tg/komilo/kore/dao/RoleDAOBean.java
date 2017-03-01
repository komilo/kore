/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import tg.komilo.kore.entities.Role;
import tg.komilo.kore.utils.SortParams;

/**
 *
 * @author komilo
 */
@Stateless
public class RoleDAOBean extends GenericDAOBean<Role, Long> implements RoleDAOBeanLocal {

    public RoleDAOBean() {
        super(Role.class);
    }

    @Override
    public Role getOne(Long id) {
        Role role = super.getOne(id);
        role.getPermissions().size();
        return role;
    }
    
    @Override
    public List<Role> getAll(Long userId, SortParams sortParams) {
        String jpql = "SELECT DISTINCT r "
                + "FROM User u JOIN u.roles r "
                + "WHERE u.id = :userId "
                + sortParams.queryChunk("r");
        Query query = this.em.createQuery(jpql);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
