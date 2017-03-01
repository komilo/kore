/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.utils;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author komilo
 */
public abstract class BaseListFilter implements IListFilter {

    @Override
    public Query getQuery(EntityManager em, SortParams sortParams) {
        return this.setParameters(em.createQuery(this.buildBaseJPQL() + sortParams.queryChunk()));
    }

    @Override
    public Query getCountQuery(EntityManager em) {
        return this.setParameters(em.createQuery(this.buildBaseJPQL(true)));
    }
    
    private String buildBaseJPQL() {
        return this.buildBaseJPQL(false);
    }
    
    public abstract String buildBaseJPQL(boolean count);
    
    public Query setParameters(Query query) {
        return query;
    }
}
