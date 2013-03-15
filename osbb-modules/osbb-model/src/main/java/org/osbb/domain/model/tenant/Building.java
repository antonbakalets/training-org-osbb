package org.osbb.domain.model.tenant;

import java.io.Serializable;
import javax.persistence.*;
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
    @Basic
    @Column(name = "bdng_id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    
    @Column(name = "floors_number")
    private String floors;
    
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer bankId) {
        this.id = bankId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Building)) {
            return false;
        }
        Building other = (Building) object;
        if ((this.id == null && other.getId() != null) || (this.id != null && !this.id.equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Building[ id=" + id + "]";
    }
}
