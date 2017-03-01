/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import javax.ejb.Remote;
import tg.komilo.kore.entities.User;
import tg.komilo.kore.entities.UserSession;

/**
 *
 * @author komilo
 */
@Remote
public interface UserSessionServiceBeanRemote extends GenericServiceBeanRemote<UserSession, Long> {
    
    void initSession(User user);
    
    void initSession(String username);
    
    void closeSession(User user);
    
    boolean isTokenValid(String token);
    
    String getToken(String username);
    
    UserSession getLast();
    
    UserSession getLast(String username);
    
    UserSession getLast(User user);
}
