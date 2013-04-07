package org.osbb.domain.model.tenant;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.osbb.domain.model.Identifiable;

/**
 *
 * @author Anton Bakalets
 */
@Entity
@Table(name = "Apartment")
public class Apartment implements Serializable, Identifiable<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "aprt_id")
    private Integer aprtId;

    @Basic(optional = false)
    @Column(name = "post_address")
    private String postAddress;

    @JoinColumn(name = "entrance", referencedColumnName = "entr_id")
    @ManyToOne
    private Entrance entrance;

    @JoinColumn(name = "building", referencedColumnName = "bdng_id")
    @ManyToOne
    private Building building;

    public Apartment() {
    }

    public Integer getId() {
        return aprtId;
    }

    public void setId(Integer aprtId) {
        this.aprtId = aprtId;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public Entrance getEntrance() {
        return entrance;
    }

    public void setEntrance(Entrance entrance) {
        this.entrance = entrance;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aprtId != null ? aprtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Apartment)) {
            return false;
        }
        Apartment other = (Apartment) object;
        if ((this.aprtId == null && other.aprtId != null)
                || (this.aprtId != null && !this.aprtId.equals(other.aprtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Apartment[ aprtId=" + aprtId + " ]";
    }
}
