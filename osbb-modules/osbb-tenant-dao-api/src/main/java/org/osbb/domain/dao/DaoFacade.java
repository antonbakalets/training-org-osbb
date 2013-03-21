package org.osbb.domain.dao;

import java.util.List;
import org.osbb.domain.bean.PaginationBean;
import org.osbb.domain.model.Identifiable;

/**
 *
 * @author Anton Bakalets
 */
public interface DaoFacade<I, T extends Identifiable<I>> {

    long count();

    void delete(T entity);

    void insert(T entity);

    T findById(I id);

    List<T> selectAll();

    List<T> selectRange(int[] range);

    List<T> selectRange(int skipResults, int maxResults);
    
    List<T> selectRange(PaginationBean paginationBean);

    void update(T entity);
    
    boolean exists(I id);
    
}
