/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.dao;

import java.util.List;
import javax.ejb.Local;
import tg.komilo.kore.entities.Role;
import tg.komilo.kore.utils.SortParams;

/**
 *
 * @author komilo
 */
@Local
public interface RoleDAOBeanLocal extends GenericDAOBeanLocal<Role, Long> {

    public List<Role> getAll(Long UserId, SortParams sortParams);
}
