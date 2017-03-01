/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.komilo.kore.dao.GenericDAOBeanLocal;
import tg.komilo.kore.dao.LogLevelDAOBeanLocal;
import tg.komilo.kore.entities.LogLevel;

/**
 *
 * @author Ramses
 */
@Stateless
public class LogLevelServiceBean extends GenericServiceBean<LogLevel, Integer> 
        implements LogLevelServiceBeanRemote{

    @EJB
    private LogLevelDAOBeanLocal dao;
    
    @Override
    protected GenericDAOBeanLocal<LogLevel, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public Integer getId(LogLevel e) {
        return e.getId();
    }
    
}
