package org.osbb.domain.dao.impl;

import org.osbb.domain.dao.api.EntranceDao;
import org.osbb.domain.model.tenant.Entrance;

/**
 *
 * @author Anton Bakalets
 */
public class EntranceDaoImpl extends AbstractTenantDao<Integer, Entrance> implements EntranceDao {

    public EntranceDaoImpl() {
        super(Entrance.class);
    }
    
}
