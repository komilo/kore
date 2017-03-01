/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.service;

import java.util.Date;
import javax.ejb.Remote;
import tg.komilo.kore.entities.Variable;

/**
 *
 * @author komilo
 */
@Remote
public interface VariableServiceBeanRemote extends GenericServiceBeanRemote<Variable, String> {
    
    void setValue(String name, Object value);
    
    void setValue(String name, String value);
    
    String getValue(String name);
    
    int getIntValue(String name);
    
    long getLongValue(String name);
    
    float getFloatValue(String name);
    
    double getDoubleValue(String name);
    
    Date getDateValue(String name);
}
