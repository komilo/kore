/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.dao;

import java.util.List;
import javax.ejb.Local;
import tg.komilo.kore.entities.Permission;
import tg.komilo.kore.utils.SortParams;

/**
 *
 * @author komilo
 */
@Local
public interface PermissionDAOBeanLocal extends GenericDAOBeanLocal<Permission, String> {

    List<Permission> findByRole(Long roleId, SortParams sortParams);

//    List<Permission> getAll(String categoryCode, SortParams sortParams);
}
