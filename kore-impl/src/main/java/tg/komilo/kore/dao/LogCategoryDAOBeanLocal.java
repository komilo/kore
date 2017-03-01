/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.dao;

import javax.ejb.Local;
import tg.komilo.kore.entities.LogCategory;

/**
 *
 * @author Ramses
 */
@Local
public interface LogCategoryDAOBeanLocal extends GenericDAOBeanLocal<LogCategory, String>{
    /**
     * 
     * @param label la catégorie à retrouver
     * @return la category du journal correspondant au label
     */
    LogCategory findByLabelCategory(String label);
}
