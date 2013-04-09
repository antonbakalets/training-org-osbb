package org.osbb.domain.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.osbb.domain.model.Identifiable;

/**
 *
 * @author Anton Bakalets
 */
abstract class AbstractSharedDao<I, T extends Identifiable<I>> extends AbstractDao<I, T> {

    @PersistenceContext(unitName = "shared-unit")
    protected EntityManager entityManager;

    public AbstractSharedDao(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
