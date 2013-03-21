package org.osbb.domain.dao.api;

import org.osbb.domain.model.shared.UserLogin;

/**
 *
 * @author Anton Bakalets
 */
public interface UserLoginDao {
    
    public UserLogin loadUserLogin(String username);
    
}
