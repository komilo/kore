/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.dao;

import javax.ejb.Stateless;
import tg.komilo.kore.entities.LogLevel;

/**
 *
 * @author Ramses
 */
@Stateless
public class LogLevelDAOBean extends GenericDAOBean<LogLevel, Integer> implements LogLevelDAOBeanLocal {

    public LogLevelDAOBean() {
        super(LogLevel.class);
    }
}
