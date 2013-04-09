package org.osbb.security;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.osbb.domain.model.shared.UserLogin;
import org.osbb.domain.model.tenant.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Anton Bakalets
 */
public class OsbbUserDetails implements UserDetails {

    private static final Logger LOG = LoggerFactory.getLogger(OsbbUserDetails.class);

    private String username;

    private String password;

    private String databaseName;

    private Integer personId;

    private Person person;

    private Set<GrantedAuthority> grantedAuthorities;

    public OsbbUserDetails(UserLogin userLogin) {
        this.username = userLogin.getUsername();
        this.password = userLogin.getPassword();
        this.databaseName = userLogin.getDatabaseName();
        this.personId = userLogin.getUserId();
        this.grantedAuthorities = Collections.emptySet();
    }

    public OsbbUserDetails(OsbbUserDetails userDetails, Person person) {
        this.username = userDetails.getUsername();
        this.password = userDetails.getPassword();
        this.databaseName = userDetails.getTenantDatabase();
        this.personId = userDetails.getPersonId();
        this.person = person;
        LOG.debug("Initializaing granthed autorities.");
        grantedAuthorities = new HashSet<GrantedAuthority>();
        /*for (UserRole role : person.getRoles()) {
            for (Permit permit : role.getPermissions()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(permit.getName()));
            }
        }*/
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO isAccountNonExpired()
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO isAccountNonLocked()
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO isCredentialsNonExpired()
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO
        return true;
    }

    /*public Organization getOrganization() {
        return person.getOrganization();
    }*/

    public Person getPerson() {
        return person;
    }

    public String getTenantDatabase() {
        return databaseName;
    }

    public Integer getPersonId() {
        return personId;
    }
}
