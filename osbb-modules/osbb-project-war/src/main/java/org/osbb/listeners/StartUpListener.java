package org.osbb.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Anton Bakalets
 */
public class StartUpListener implements ServletContextListener {

    private static Log LOG = LogFactory.getLog(StartUpListener.class);

    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        LOG.info("OSBB Servlet Start Up!");
    }

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
        LOG.info("Stoping OSBB Servlet...");
    }
}
