package org.osbb.multitenancy;

import org.springframework.util.Assert;

/**
 *
 * @author Anton Bakalets
 */
public class ThreadLocalDatabaseNameHolder {

    private static final ThreadLocal<String> databaseNameHolder = new ThreadLocal<String>();

    public static String getDatabaseName() {
        String holded = databaseNameHolder.get();
        return holded;
    }

    public static void setDatabaseName(String databaseName) {
        Assert.notNull(databaseName, "Only non-null database name are permitted");
        databaseNameHolder.set(databaseName);
    }
}
