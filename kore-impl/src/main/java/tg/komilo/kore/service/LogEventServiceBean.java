/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.komilo.kore.dao.GenericDAOBeanLocal;
import tg.komilo.kore.dao.LogEventDAOBeanLocal;
import tg.komilo.kore.entities.LogEvent;


/**
 *
 * @author Ramses
 */
@Stateless
public class LogEventServiceBean extends GenericServiceBean<LogEvent, Long>
        implements LogEventServiceBeanRemote {

    @EJB
    private LogEventDAOBeanLocal dao;

    @Override
    protected GenericDAOBeanLocal<LogEvent, Long> getDAO() {
        return this.dao;
    }

    @Override
    public Long getId(LogEvent e) {
        return e.getId();
    }

}
