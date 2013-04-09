package org.osbb.multitenancy;

import org.osbb.datasource.AbstractDatabaseAwareDataSource;

/**
 *
 * @author Anton Bakalets
 */
public class TenantAwareDataSource extends AbstractDatabaseAwareDataSource {

    @Override
    protected String determineCurrentDatabaseName() {
        return ThreadLocalDatabaseNameHolder.getDatabaseName();
    }
}
