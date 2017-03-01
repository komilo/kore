/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import java.util.List;
import javax.ejb.Remote;
import tg.komilo.kore.entities.Role;
import tg.komilo.kore.entities.User;

/**
 *
 * @author persistence
 */
@Remote
public interface RoleServiceBeanRemote extends GenericServiceBeanRemote<Role, Long> {
    
    /**
     * Renvoie les roles associés à un utilisateur.
     * @param user L'utilisateur.
     * @return La liste des rôles.
     */
    List<Role> getAll(User user);
}
