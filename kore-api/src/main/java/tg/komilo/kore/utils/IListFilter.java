/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.utils;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author komilo
 */
public interface IListFilter extends Serializable {
    
    Query getQuery(EntityManager em, SortParams sortParams);
    
    Query getCountQuery(EntityManager em);
}
