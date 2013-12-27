/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantgrower;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jérôme
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByIdLOCATION", query = "SELECT l FROM Location l WHERE l.idLOCATION = :idLOCATION"),
    @NamedQuery(name = "Location.findByName", query = "SELECT l FROM Location l WHERE l.name = :name"),
    @NamedQuery(name = "Location.findByAddress", query = "SELECT l FROM Location l WHERE l.address = :address"),
    @NamedQuery(name = "Location.findByCoordinates", query = "SELECT l FROM Location l WHERE l.coordinates = :coordinates")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLOCATION")
    private Integer idLOCATION;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NAME")
    private String name;
    @Size(max = 45)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 100)
    @Column(name = "COORDINATES")
    private String coordinates;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lOCATIONidLOCATION")
    private Collection<Plant> plantCollection;

    public Location() {
    }

    public Location(Integer idLOCATION) {
        this.idLOCATION = idLOCATION;
    }

    public Location(Integer idLOCATION, String name) {
        this.idLOCATION = idLOCATION;
        this.name = name;
    }

    public Integer getIdLOCATION() {
        return idLOCATION;
    }

    public void setIdLOCATION(Integer idLOCATION) {
        this.idLOCATION = idLOCATION;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @XmlTransient
    public Collection<Plant> getPlantCollection() {
        return plantCollection;
    }

    public void setPlantCollection(Collection<Plant> plantCollection) {
        this.plantCollection = plantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLOCATION != null ? idLOCATION.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idLOCATION == null && other.idLOCATION != null) || (this.idLOCATION != null && !this.idLOCATION.equals(other.idLOCATION))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "plantgrower.Location[ idLOCATION=" + idLOCATION + " ]";
    }
    
}
