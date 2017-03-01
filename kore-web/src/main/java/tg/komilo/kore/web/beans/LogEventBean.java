/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.web.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import tg.komilo.kore.entities.LogEvent;
import tg.komilo.kore.service.LogEventServiceBeanRemote;
import tg.komilo.kore.web.models.GenericDataModel;

/**
 *
 * @author komilo
 */
@ManagedBean
@ViewScoped
public class LogEventBean implements Serializable {
    
    @EJB
    private LogEventServiceBeanRemote service;
    
    public DataModel<LogEvent> getModel() {
        return new GenericDataModel<>(this.service);
    }
}
