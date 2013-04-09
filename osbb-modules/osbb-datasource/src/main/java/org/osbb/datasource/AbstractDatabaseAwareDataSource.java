package org.osbb.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.util.Assert;

/**
 * http://forum.springsource.org/showthread.php?111356-AbstractRoutingDataSource-and-TransactionManager
 *
 * @author Anton Bakalets
 */
public abstract class AbstractDatabaseAwareDataSource extends AbstractDataSource implements InitializingBean {

    private static Logger LOG = LoggerFactory.getLogger(AbstractDatabaseAwareDataSource.class);
    
    private Map<String, DataSource> dataSources;

    private DataSourceFactory dataSourceFactory;

    /**
     * {@inheritDoc}
     */
    public void afterPropertiesSet() {
        if (this.dataSourceFactory == null) {
            final IllegalArgumentException iae = new IllegalArgumentException("Property 'dataSourceFactory' is required.");
            LOG.error("Property 'dataSourceFactory' is required.", iae);
            throw iae;
        }
        this.dataSources = new HashMap<String, DataSource>();
    }

    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    /**
     * {@inheritDoc}
     */
    public Connection getConnection() throws SQLException {
        return determineTargetDataSource().getConnection();
    }

    /**
     * {@inheritDoc}
     */
    public Connection getConnection(String username, String password) throws SQLException {
        return determineTargetDataSource().getConnection(username, password);
    }

    /**
     * Retrieve the current target DataSource. Determines the {@link #determineCurrentDatabaseName() current lookup key},
     * performs a lookup in the {@link #setTargetDataSources targetDataSources} map, falls back to the specified
     * {@link #setDefaultTargetDataSource default target DataSource} if necessary.
     *
     * @see #determineCurrentDatabaseName()
     */
    public DataSource determineTargetDataSource() {
        Assert.notNull(this.dataSources, "DataSource router not initialized");
        String databaseName = determineCurrentDatabaseName();
        DataSource dataSource = this.dataSources.get(databaseName);
        if (dataSource == null) {
            try {
                dataSource = dataSourceFactory.createDataSource(databaseName);
                dataSources.put(databaseName, dataSource);
            } catch (Exception ex) {
                LOG.error("Exception if an error occurs creating the data source", ex);
            }
        }
        return dataSource;
    }

    /**
     * Determine the current lookup key. This will typically be implemented to check a thread-bound transaction context.
     * <p>Allows for arbitrary keys. The returned key needs to match the stored lookup key type, as resolved by the
     * {@link #resolveSpecifiedLookupKey} method.
     */
    protected abstract String determineCurrentDatabaseName();
}
