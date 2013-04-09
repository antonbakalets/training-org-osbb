package org.osbb.domain.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.osbb.domain.model.Identifiable;

/**
 *
 * @author Anton Bakalets
 */
abstract class AbstractTenantDao<I, T extends Identifiable<I>> extends AbstractDao<I, T> {

    @PersistenceContext(unitName = "tenant-unit")
    protected EntityManager entityManager;

    public AbstractTenantDao(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
