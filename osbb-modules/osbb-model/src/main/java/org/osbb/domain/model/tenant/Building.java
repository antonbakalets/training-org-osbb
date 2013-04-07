package org.osbb.domain.model.tenant;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.osbb.domain.model.Identifiable;

/**
 *
 * @author Anton Bakalets
 */
@Entity
@Table(name = "Building")
public class Building implements Serializable, Identifiable<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "bdng_id")
    private Integer bdngId;

    @Basic(optional = false)
    @Column(name = "address")
    private String address;

    @Basic(optional = false)
    @Column(name = "floors_number")
    private int floorsNumber;

    public Building() {
    }

    public Integer getId() {
        return bdngId;
    }

    public void setId(Integer id) {
        this.bdngId = id;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(int floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bdngId != null ? bdngId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Building)) {
            return false;
        }
        Building other = (Building) object;
        if ((this.bdngId == null && other.bdngId != null)
                || (this.bdngId != null && !this.bdngId.equals(other.bdngId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Building[ bdngId=" + bdngId + " ]";
    }
}
