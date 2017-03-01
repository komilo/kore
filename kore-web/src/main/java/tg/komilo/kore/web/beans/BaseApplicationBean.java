/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.web.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import tg.komilo.kore.entities.User;
import tg.komilo.kore.entities.UserSession;
import tg.komilo.kore.service.UserServiceBeanRemote;
import tg.komilo.kore.service.UserSessionServiceBeanRemote;
import tg.komilo.kore.utils.KoreConstants;

/**
 *
 * @author komilo
 */
public abstract class BaseApplicationBean implements Serializable {

    @EJB
    private UserServiceBeanRemote userService;
    
    @EJB
    private UserSessionServiceBeanRemote userSessionService;

    public abstract String getApplicationName();

    public abstract String getApplicationDisplayName();

    public abstract String getApplicationSlogan();

    public abstract String getMenuFilePath();

    public abstract String getSecondaryMenuFilePath();
    
    public String getApplicationDisplayNameFirstLetter() {
        return this.getApplicationDisplayName().substring(0, 1);
    }
    
    public String getApplicationDisplayNameFirstLetterLess() {
        return this.getApplicationDisplayName().substring(1);
    }

    public User getCurrentUser() {
        return this.userService.getCurrent();
    }
    
    public UserSession getCurrentUserLastSession() {
        return this.userSessionService.getLast();
    }
    
    public String getCurrentUserName() {
        return this.getCurrentUser().getUsername();
    }
    
    public String getCurrentUserQualification() {
        return "";
    }

    public String logout() {
        this.userService.logout();
        return "/";
    }
    
    public String getMediumDateTimeFormat() {
        return "dd/MM/yyyy H:m:s";
    }

    // Menu permissions
    public boolean canAccessUsers() {
        return this.userService.isPermitted(KoreConstants.PERM_SECURITY_USER_LIST);
    }

    public boolean canAccessRoles() {
        return this.userService.isPermitted(KoreConstants.PERM_SECURITY_ROLE_LIST);
    }

    public boolean canAccessLogs() {
        return this.userService.isPermitted(KoreConstants.PERM_LOG_LIST);
    }

    public boolean canAccessBackupBackup() {
        return this.userService.isPermitted(KoreConstants.PERM_BACKUP_BACKUP);
    }

    public boolean canAccessBackupRestore() {
        return this.userService.isPermitted(KoreConstants.PERM_BACKUP_RESTORE);
    }

    public boolean canAccessBackupConfigure() {
        return this.userService.isPermitted(KoreConstants.PERM_BACKUP_CONFIGURE);
    }

    public boolean canAccessSchedulerConsult() {
        return this.userService.isPermitted(KoreConstants.PERM_SCHEDULER_CONSULT);
    }

    public boolean canAccessSchedulerExecute() {
        return this.userService.isPermitted(KoreConstants.PERM_SCHEDULER_EXECUTE);
    }

    public boolean canAccessSchedulerPlanify() {
        return this.userService.isPermitted(KoreConstants.PERM_SCHEDULER_PLANIFY);
    }

    public boolean canAccessSchedulerView() {
        return this.userService.isPermitted(KoreConstants.PERM_SCHEDULER_VIEW);
    }
}
