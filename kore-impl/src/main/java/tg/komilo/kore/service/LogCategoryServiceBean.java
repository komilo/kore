/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.komilo.kore.dao.GenericDAOBeanLocal;
import tg.komilo.kore.dao.LogCategoryDAOBeanLocal;
import tg.komilo.kore.entities.LogCategory;


/**
 *
 * @author Ramses
 */
@Stateless
public class LogCategoryServiceBean extends GenericServiceBean<LogCategory, String> 
        implements LogCategoryServiceBeanRemote{

    @EJB
    private LogCategoryDAOBeanLocal dao;
    
    @Override
    protected GenericDAOBeanLocal<LogCategory, String> getDAO() {
        return this.dao;
    }

    @Override
    public String getId(LogCategory e) {
        return e.getCode();
    }

    @Override
    public LogCategory findbylabelCategory(String label) {
        return this.dao.findByLabelCategory(label);
    }
}