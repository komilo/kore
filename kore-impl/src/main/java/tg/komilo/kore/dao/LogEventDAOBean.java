/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.dao;

import javax.ejb.Stateless;
import tg.komilo.kore.entities.LogEvent;

/**
 *
 * @author Ramses
 */
@Stateless
public class LogEventDAOBean extends GenericDAOBean<LogEvent, Long> implements LogEventDAOBeanLocal {
    
    public LogEventDAOBean() {
        super(LogEvent.class);
    }
    
}
