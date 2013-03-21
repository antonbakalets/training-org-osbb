package org.osbb.datasource;

/**
 *
 * @author Anton Bakalets
 */
public interface ConnectionUrlFactory {

    String createConnectionUrl();

    String createConnectionUrl(String shema);
   
}
