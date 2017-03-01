/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import java.util.List;
import javax.ejb.Remote;
import tg.komilo.kore.entities.Permission;
import tg.komilo.kore.entities.PermissionCategory;
import tg.komilo.kore.utils.SortParams;
/**
 *
 * @author persistence
 */
@Remote
public interface PermissionServiceBeanRemote extends GenericServiceBeanRemote<Permission, String> {

    /**
     * Renvoie la liste des permissions d'une catégorie de permission.
     * @param category La catégorie.
     * @return La liste.
     */
    List<Permission> getAll(PermissionCategory category);
    
    /**
     * Renvoie la liste des permissions d'une catégorie de permission triée selon les 
     * SortParam.
     * @param category La catégorie.
     * @param sortParams Les paramètres de tri.
     * @return La liste.
     */
    List<Permission> getAll(PermissionCategory category, SortParams sortParams);
}
