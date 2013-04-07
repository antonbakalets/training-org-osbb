package org.osbb.domain.dao.impl;

import org.osbb.domain.dao.api.ApartmentDao;
import org.osbb.domain.model.tenant.Apartment;

/**
 *
 * @author Anton Bakalets
 */
public class ApartmentDaoImpl extends AbstractTenantDao<Integer, Apartment> implements ApartmentDao {

    public ApartmentDaoImpl() {
        super(Apartment.class);
    }
}
