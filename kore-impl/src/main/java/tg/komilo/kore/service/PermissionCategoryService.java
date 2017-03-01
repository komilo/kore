/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.komilo.kore.dao.GenericDAOBeanLocal;
import tg.komilo.kore.dao.PermissionCategoryDAOBeanLocal;
import tg.komilo.kore.entities.PermissionCategory;


/**
 *
 * @author persistence
 */
@Stateless
public class PermissionCategoryService extends GenericServiceBean<PermissionCategory, String> 
        implements PermissionCategoryServiceBeanRemote {
    
    @EJB
    private PermissionCategoryDAOBeanLocal dao;

    @Override
    protected GenericDAOBeanLocal<PermissionCategory, String> getDAO() {
        return this.dao;
    }

    @Override
    public String getId(PermissionCategory e) {
        return e.getCode();
    }
    
}
