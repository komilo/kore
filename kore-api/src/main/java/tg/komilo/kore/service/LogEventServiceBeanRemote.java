/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import javax.ejb.Remote;
import tg.komilo.kore.entities.LogEvent;

/**
 *
 * @author Ramses
 */
@Remote
public interface LogEventServiceBeanRemote extends GenericServiceBeanRemote<LogEvent, Long>{
    
}
