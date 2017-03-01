/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.web.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import tg.komilo.kore.entities.BaseEntity;
import tg.komilo.kore.service.GenericServiceBeanRemote;
import tg.komilo.kore.utils.FilterParams;
import tg.komilo.kore.utils.SortDirection;
import tg.komilo.kore.utils.SortParam;
import tg.komilo.kore.utils.SortParams;

/**
 * DataModel de base pour les opérations CRUD.
 *
 * @author komilo
 * @param <E> La classe entité.
 * @param <ID> Type de la clé primaire de l'entité.
 */
public class GenericDataModel<E extends BaseEntity, ID extends Serializable> extends LazyDataModel<E> {

    private final GenericServiceBeanRemote<E, ID> service;
    private int rowCount = -1;

    public GenericDataModel(GenericServiceBeanRemote<E, ID> service) {
        this.service = service;
    }

    @Override
    public int getRowCount() {
        if (this.rowCount == -1) {
            this.rowCount = this.service.count().intValue();
        }
        return this.rowCount;
    }

//    public T getRowData() {
//        List<T> tmp = this.service.selectionnerAvecLimite(this.getRowIndex(), 1);
//        return tmp.isEmpty() ? null : tmp.get(0);
//    }
    @Override
    public Object getRowKey(E object) {
        return this.service.getId(object);
    }

//    @Override
//    public T getRowData(String rowKey) {
//        return this.service.selectionnerApartirDeId(rowKey);
//    }
    @Override
    public List<E> load(int first, int pageSize, String sortField,
            SortOrder sortOrder, Map<String, Object> filters) {
        return this.service.getAll(first, pageSize,
                this.buidSortParams(sortField, sortOrder), FilterParams.from(filters));
    }

    @Override
    public List<E> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String, Object> filters) {
        return this.service.getAll(first, pageSize,
                this.buidSortParams(multiSortMeta), FilterParams.from(filters));
    }

    private SortParams buidSortParams(String sortField, SortOrder sortOrder) {
        return SortParams.from(sortField, this.getSortDirection(sortOrder));
    }

    private SortParams buidSortParams(List<SortMeta> multiSortMeta) {
        List<SortParam> params = new LinkedList<>();
        if (multiSortMeta != null) {
            for (SortMeta meta : multiSortMeta) {
                params.add(SortParam.from(meta.getSortField(), this.getSortDirection(meta.getSortOrder())));
            }
        }
        return SortParams.from(params);
    }

    private SortDirection getSortDirection(SortOrder sortOrder) {
        switch (sortOrder) {
            case ASCENDING:
                return SortDirection.ASCENDING;
            case DESCENDING:
                return SortDirection.DESCENDING;
            default:
                return SortDirection.UNSORTED;
        }
    }
}
