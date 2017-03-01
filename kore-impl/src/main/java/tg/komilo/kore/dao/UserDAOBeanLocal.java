/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.dao;

import javax.ejb.Local;
import tg.komilo.kore.entities.User;

/**
 *
 * @author komilo
 */
@Local
public interface UserDAOBeanLocal extends GenericDAOBeanLocal<User, Long> {

    User findByUsername(String username);
    
    String getPassword(Long userId);
}
