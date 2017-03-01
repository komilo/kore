/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.web.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author komilo
 */
@ManagedBean
@ApplicationScoped
public class ApplicationBean extends BaseApplicationBean {
    
    public static final String MENU_FILE_PATH = "/kore/templates/menu.xhtml";
    public static final String SECONDARY_MENU_FILE_PATH = "/kore/templates/secondary-menu.xhtml";

    @Override
    public String getApplicationName() {
        return "kore-web-test";
    }

    @Override
    public String getApplicationDisplayName() {
        return "Kore Web Test";
    }

    @Override
    public String getApplicationSlogan() {
        return "Kore Slogan!";
    }

    @Override
    public String getMenuFilePath() {
        return MENU_FILE_PATH;
    }

    @Override
    public String getSecondaryMenuFilePath() {
        return SECONDARY_MENU_FILE_PATH;
    }
    
}
