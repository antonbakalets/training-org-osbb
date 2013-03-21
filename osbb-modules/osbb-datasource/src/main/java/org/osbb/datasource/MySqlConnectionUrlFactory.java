package org.osbb.datasource;

/**
 *
 * @author Anton Bakalets
 */
public class MySqlConnectionUrlFactory implements ConnectionUrlFactory {

    public static final String JDBC_MYSQL = "jdbc:mysql://";

    private String host;

    private String port;

    private String defaultDatabase;

    public String createConnectionUrl() {
        return createConnectionUrl(defaultDatabase);
    }

    public String createConnectionUrl(String database) {
        StringBuilder result = new StringBuilder(JDBC_MYSQL);
        if (host != null) {
            result.append(host);
        }
        if (port != null) {
            result.append(":").append(port);
        }
        result.append("/");
        if (database != null) {
            result.append(database);
        }
        return result.toString();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDefaultDatabase() {
        return defaultDatabase;
    }

    public void setDefaultDatabase(String defaultDatabase) {
        this.defaultDatabase = defaultDatabase;
    }
}
