/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.dao;

import javax.ejb.Stateless;
import tg.komilo.kore.entities.PermissionCategory;

/**
 *
 * @author komilo
 */
@Stateless
public class PermissionCategoryDAOBean extends GenericDAOBean<PermissionCategory, String>
        implements PermissionCategoryDAOBeanLocal {

    public PermissionCategoryDAOBean() {
        super(PermissionCategory.class);
    }
}
