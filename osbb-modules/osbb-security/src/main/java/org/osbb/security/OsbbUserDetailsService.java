package org.osbb.security;

import javax.persistence.NoResultException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osbb.domain.dao.api.UserLoginDao;
import org.osbb.domain.model.shared.UserLogin;
import org.osbb.multitenancy.ThreadLocalDatabaseNameHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Anton Bakalets
 */
public class OsbbUserDetailsService implements UserDetailsService {

    private static final Log LOG = LogFactory.getLog(OsbbUserDetailsService.class);
    
    private UserLoginDao userLoginDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        try {
            LOG.debug("Loading user by username: " + username);
            final UserLogin userLogin = userLoginDao.loadUserLogin(username);
            LOG.debug("Loaded user: " + userLogin + ", worker id: " + userLogin.getUserId());
            ThreadLocalDatabaseNameHolder.setDatabaseName(userLogin.getDatabaseName());
            return new OsbbUserDetails(userLogin);
        } catch (NoResultException nre) {
            LOG.debug("Cannot find user by name: " + username);
            throw new UsernameNotFoundException("No user with name: " + username);
        }
    }
    
    public UserLoginDao getUserLoginDao() {
        return userLoginDao;
    }

    public void setUserLoginDao(UserLoginDao userLoginDao) {
        this.userLoginDao = userLoginDao;
    }
}
