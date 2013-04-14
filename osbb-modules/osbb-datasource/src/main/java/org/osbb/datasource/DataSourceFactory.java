package org.osbb.datasource;

import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Anton Bakalets
 */
public class DataSourceFactory {

    private static Logger LOG = LoggerFactory.getLogger(DataSourceFactory.class);

    private String driverClassName;

    private ConnectionUrlFactory connectionUrlFactory;

    private String username;

    private String password;

    private String connectionProperties;

    /**
     * *
     * Creates and configures a {@link BasicDataSource} instance based on the given properties.
     *
     * @param database the name of the schema
     * @return {@link BasicDataSource} object
     * @throws Exception if an error occurs creating the data source
     */
    public BasicDataSource createDataSource(String database) throws Exception {
        final String url = createUrl(database);
        LOG.debug("Creating datasource for lookup key [{}], url: {}", database, url);

        Properties properties = new Properties();
        properties.setProperty("driverClassName", driverClassName);
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);
        properties.setProperty("connectionProperties", connectionProperties);

        properties.setProperty("maxActive", "10");
        properties.setProperty("maxIdle", "8");
        properties.setProperty("minIdle", "0");
        properties.setProperty("maxWait", "10000");
        properties.setProperty("initialSize", "5");
        properties.setProperty("removeAbandoned", "true");
        properties.setProperty("removeAbandonedTimeout", "60");
        properties.setProperty("validationQuery", "SELECT 1");
        properties.setProperty("validationInterval", "300000");
        properties.setProperty("timeBetweenEvictionRunsMillis", "1800000");
        properties.setProperty("minEvictableIdleTimeMillis", "3600000");
        properties.setProperty("numTestsPerEvictionRun", "10");
        properties.setProperty("logAbandoned", "true");
        properties.setProperty("testWhileIdle", "true");
        properties.setProperty("testOnBorrow", "true");
        properties.setProperty("testOnReturn", "false");

        BasicDataSource dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(properties);
        return dataSource;
    }

    private String createUrl(String database) {
        if (database == null) {
            return connectionUrlFactory.createConnectionUrl();
        } else {
            return connectionUrlFactory.createConnectionUrl(database);
        }
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setConnectionUrlFactory(ConnectionUrlFactory connectionUrlFactory) {
        this.connectionUrlFactory = connectionUrlFactory;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConnectionProperties(String connectionProperties) {
        this.connectionProperties = connectionProperties;
    }
}
