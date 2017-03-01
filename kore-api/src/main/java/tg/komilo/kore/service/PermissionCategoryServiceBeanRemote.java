/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import javax.ejb.Remote;
import tg.komilo.kore.entities.PermissionCategory;

/**
 *
 * @author persistence
 */
@Remote
public interface PermissionCategoryServiceBeanRemote 
        extends GenericServiceBeanRemote<PermissionCategory, String> {

}
