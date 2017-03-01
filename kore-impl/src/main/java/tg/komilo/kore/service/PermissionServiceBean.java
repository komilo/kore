/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.komilo.kore.dao.GenericDAOBeanLocal;
import tg.komilo.kore.dao.PermissionDAOBeanLocal;
import tg.komilo.kore.entities.Permission;
import tg.komilo.kore.entities.PermissionCategory;
import tg.komilo.kore.utils.FilterParams;
import tg.komilo.kore.utils.SortDirection;
import tg.komilo.kore.utils.SortParams;

/**
 *
 * @author persistence
 */
@Stateless
public class PermissionServiceBean extends GenericServiceBean<Permission, String>
        implements PermissionServiceBeanRemote {

    @EJB
    private PermissionDAOBeanLocal dao;

    @Override
    protected GenericDAOBeanLocal<Permission, String> getDAO() {
        return this.dao;
    }

    @Override
    public String getId(Permission e) {
        return e.getCode();
    }

    @Override
    public List<Permission> getAll(PermissionCategory category) {
        return this.getAll(category, SortParams.from("label", SortDirection.ASCENDING));
    }

    @Override
    public List<Permission> getAll(PermissionCategory category, SortParams sortParams) {
//        return this.dao.getAll(category.getCode(), sortParams);
        return this.dao.getAll(sortParams, FilterParams.from("category.code", category.getCode()));
    }

}
