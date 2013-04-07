package org.osbb.domain.dao.impl;

import org.osbb.domain.dao.api.BuildingDao;
import org.osbb.domain.model.tenant.Building;

/**
 *
 * @author Anton Bakalets
 */
public class BuildingDaoImpl extends AbstractTenantDao<Integer, Building> implements BuildingDao {

    public BuildingDaoImpl() {
        super(Building.class);
    }
}
