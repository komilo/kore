/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import java.util.List;
import javax.ejb.Remote;
import tg.komilo.kore.entities.Permission;
import tg.komilo.kore.entities.Role;
import tg.komilo.kore.entities.User;

/**
 *
 * @author persistence
 */
@Remote
public interface UserServiceBeanRemote extends GenericServiceBeanRemote<User, Long> {
    
    User findByUsername(String username);
    
    List<Role> findRolesForUser(Long id);
    
    List<Permission> findPermissionsForRole(Long roleId);
    
    User getCurrent();
    
    String getClientIPAdress();
    
    boolean login(User user);
    
    boolean login(String username, String password);
    
    boolean login(String username, String password, boolean rememberMe);
    
    void logout();
    
    void logout(String token);
    
    boolean isPermitted(String permissionCode);
    
    boolean isPermitted(Permission permission);
}
