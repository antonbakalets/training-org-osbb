package org.osbb.security;

import org.osbb.domain.dao.api.PersonDao;
import org.osbb.domain.model.tenant.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Anton Bakalets
 */
public class OsbbAuthenticationProvider extends DaoAuthenticationProvider {

    private static final Logger LOG = LoggerFactory.getLogger(OsbbAuthenticationProvider.class);

    private PersonDao personDao;

    private GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();

    /**
     * Creates a successful {@link Authentication} object. <p>Protected so subclasses can override.</p>
     * <p>Subclasses will usually store the original credentials the user supplied (not salted or encoded passwords) in
     * the returned <code>Authentication</code> object.</p>
     *
     * @param principal that should be the principal in the returned object (defined by the {@link
     *        #isForcePrincipalAsString()} method)
     * @param authentication that was presented to the provider for validation
     * @param user that was loaded by the implementation
     *
     * @return the successful authentication token
     */
    @Override
    protected Authentication createSuccessAuthentication(Object principal, Authentication authentication, UserDetails user) {
        // Ensure we return the original credentials the user supplied,
        // so subsequent attempts are successful even with encoded passwords.
        // Also ensure we return the original getDetails(), so that future
        // authentication events after cache expiry contain the details

        OsbbUserDetails userDetails = (OsbbUserDetails) user;
        final Integer workerId = userDetails.getPersonId();

        LOG.debug("Loading person by identifier: {}", workerId);
        final Person person = personDao.findById(workerId);
        LOG.debug("Loaded person: {}", person);
        final OsbbUserDetails loadedPrincipal = new OsbbUserDetails(userDetails, person);

        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(loadedPrincipal,
                authentication.getCredentials(), authoritiesMapper.mapAuthorities(loadedPrincipal.getAuthorities()));
        result.setDetails(authentication.getDetails());

        return result;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
