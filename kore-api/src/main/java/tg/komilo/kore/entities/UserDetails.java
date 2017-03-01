/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.entities;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author komilo
 */
@MappedSuperclass
public abstract class UserDetails extends BaseEntity {
    
    public abstract String getDisplayName();
    
    public abstract String getDisplayDistinction();
}
