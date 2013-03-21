package org.osbb.domain.dao.api.shared;

import org.osbb.domain.model.shared.UserLogin;

/**
 *
 * @author Anton Bakalets
 */
public interface UserLoginDao {
    
    public UserLogin loadUserLogin(String username);
    
}
