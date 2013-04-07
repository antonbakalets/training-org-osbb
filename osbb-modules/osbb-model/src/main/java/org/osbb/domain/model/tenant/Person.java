package org.osbb.domain.model.tenant;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.osbb.domain.model.Identifiable;

/**
 *
 * @author Anton Bakalets
 */
@Entity
@Table(name = "Person")
public class Person implements Serializable, Identifiable<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prsn_id")
    private Integer prsnId;

    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;

    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "midleName")
    private String midleName;

    public Person() {
    }

    public Integer getId() {
        return prsnId;
    }

    public void setId(Integer prsnId) {
        this.prsnId = prsnId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidleName() {
        return midleName;
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prsnId != null ? prsnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.prsnId == null && other.prsnId != null)
                || (this.prsnId != null && !this.prsnId.equals(other.prsnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person[ prsnId=" + prsnId + " ]";
    }
}
