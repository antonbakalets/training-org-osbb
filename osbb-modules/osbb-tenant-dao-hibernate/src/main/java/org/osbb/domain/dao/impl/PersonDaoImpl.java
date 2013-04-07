package org.osbb.domain.dao.impl;

import org.osbb.domain.dao.api.PersonDao;
import org.osbb.domain.model.tenant.Person;

/**
 *
 * @author Anton Bakalets
 */
public class PersonDaoImpl extends AbstractTenantDao<Integer, Person> implements PersonDao {

    public PersonDaoImpl() {
        super(Person.class);
    }
}
