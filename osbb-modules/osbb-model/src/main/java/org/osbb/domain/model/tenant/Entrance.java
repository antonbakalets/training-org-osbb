package org.osbb.domain.model.tenant;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.osbb.domain.model.Identifiable;

/**
 *
 * @author Anton Bakalets
 */
@Entity
@Table(name = "Entrance")
public class Entrance implements Serializable, Identifiable<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "entr_id")
    private Integer entrId;

    @Basic(optional = false)
    @Column(name = "number")
    private int number;

    @OneToMany(mappedBy = "entrance")
    private List<Apartment> apartmentList;

    @JoinColumn(name = "building", referencedColumnName = "bdng_id")
    @ManyToOne(optional = false)
    private Building building;

    public Entrance() {
    }

    public Integer getId() {
        return entrId;
    }

    public void setId(Integer entrId) {
        this.entrId = entrId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Apartment> getApartmentList() {
        return apartmentList;
    }

    public void setApartmentList(List<Apartment> apartmentList) {
        this.apartmentList = apartmentList;
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
        hash += (entrId != null ? entrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Entrance)) {
            return false;
        }
        Entrance other = (Entrance) object;
        if ((this.entrId == null && other.entrId != null)
                || (this.entrId != null && !this.entrId.equals(other.entrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entrance[ entrId=" + entrId + " ]";
    }
}
