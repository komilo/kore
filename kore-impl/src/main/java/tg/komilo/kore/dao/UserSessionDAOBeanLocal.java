/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.dao;

import javax.ejb.Local;
import tg.komilo.kore.entities.UserSession;

/**
 *
 * @author komilo
 */
@Local
public interface UserSessionDAOBeanLocal extends GenericDAOBeanLocal<UserSession, Long> {
    
    UserSession getLastByUserId(Long userId);
    
    boolean isTokenValid(String token);
    
    String getToken(String username);
}
