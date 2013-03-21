package org.osbb.domain.dao;

import java.util.List;
import javax.persistence.NoResultException;
import org.osbb.domain.bean.AutoCompleteEntry;
import org.osbb.domain.model.Identifiable;

/**
 *
 * @author Anton Bakalets
 */
public interface AutoCompleteDaoFacade<I, T extends Identifiable<I>> {

    void insert(T entity);

    T findById(I id);
    
    T findByValue(String value) throws NoResultException;

    List<AutoCompleteEntry> selectEntries();
}
