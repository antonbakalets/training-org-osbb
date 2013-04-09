package org.osbb.security;

import org.osbb.domain.model.tenant.Person;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Anton Bakalets
 */
public class SecurityService {

    public OsbbUserDetails getUserDetails() {
        return (OsbbUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public Person getWorker() {
        return getUserDetails().getPerson();
    }
}
