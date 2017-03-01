/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.web.listeners;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import tg.komilo.kore.service.ConfigServiceBeanRemote;

/**
 *
 * @author komilo
 */
@WebListener
public class DefaultServletListener implements ServletContextListener {

    @EJB
    private ConfigServiceBeanRemote configService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.configService.initConfig();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
