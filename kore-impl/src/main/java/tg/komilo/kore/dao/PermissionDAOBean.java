/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import tg.komilo.kore.entities.Permission;
import tg.komilo.kore.utils.SortParams;

/**
 *
 * @author komilo
 */
@Stateless
public class PermissionDAOBean extends GenericDAOBean<Permission, String> 
        implements PermissionDAOBeanLocal {

    public PermissionDAOBean() {
        super(Permission.class);
    }

    @Override
    public List<Permission> findByRole(Long roleId, SortParams sortParams) {
        String jpql = "SELECT DISTINCT p "
                + "FROM Role r JOIN r.permissions p "
                + "WHERE r.id = :roleId "
                + sortParams.queryChunk("p");
        Query query = this.em.createQuery(jpql);
        query.setParameter("roleId", roleId);
        return query.getResultList();
    }
}
