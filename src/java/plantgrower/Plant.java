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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "plant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plant.findAll", query = "SELECT p FROM Plant p"),
    @NamedQuery(name = "Plant.findByIdPLANT", query = "SELECT p FROM Plant p WHERE p.idPLANT = :idPLANT"),
    @NamedQuery(name = "Plant.findByPlantIdString", query = "SELECT p FROM Plant p WHERE p.plantIdString = :plantIdString"),
    @NamedQuery(name = "Plant.findByName", query = "SELECT p FROM Plant p WHERE p.name = :name"),
    @NamedQuery(name = "Plant.findByDescription", query = "SELECT p FROM Plant p WHERE p.description = :description")})
public class Plant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPLANT")
    private Integer idPLANT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PLANT_ID_STRING")
    private String plantIdString;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NAME")
    private String name;
    @Size(max = 45)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "LOCATION_idLOCATION", referencedColumnName = "idLOCATION")
    @ManyToOne(optional = false)
    private Location lOCATIONidLOCATION;
    @JoinColumn(name = "GROWTH_LOG_idGROWTH_LOG", referencedColumnName = "idGROWTH_LOG")
    @ManyToOne(optional = false)
    private GrowthLog gROWTHLOGidGROWTHLOG;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pLANTidPLANT")
    private Collection<Sensor> sensorCollection;

    public Plant() {
    }

    public Plant(Integer idPLANT) {
        this.idPLANT = idPLANT;
    }

    public Plant(Integer idPLANT, String plantIdString, String name) {
        this.idPLANT = idPLANT;
        this.plantIdString = plantIdString;
        this.name = name;
    }

    public Integer getIdPLANT() {
        return idPLANT;
    }

    public void setIdPLANT(Integer idPLANT) {
        this.idPLANT = idPLANT;
    }

    public String getPlantIdString() {
        return plantIdString;
    }

    public void setPlantIdString(String plantIdString) {
        this.plantIdString = plantIdString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLOCATIONidLOCATION() {
        return lOCATIONidLOCATION;
    }

    public void setLOCATIONidLOCATION(Location lOCATIONidLOCATION) {
        this.lOCATIONidLOCATION = lOCATIONidLOCATION;
    }

    public GrowthLog getGROWTHLOGidGROWTHLOG() {
        return gROWTHLOGidGROWTHLOG;
    }

    public void setGROWTHLOGidGROWTHLOG(GrowthLog gROWTHLOGidGROWTHLOG) {
        this.gROWTHLOGidGROWTHLOG = gROWTHLOGidGROWTHLOG;
    }

    @XmlTransient
    public Collection<Sensor> getSensorCollection() {
        return sensorCollection;
    }

    public void setSensorCollection(Collection<Sensor> sensorCollection) {
        this.sensorCollection = sensorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPLANT != null ? idPLANT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plant)) {
            return false;
        }
        Plant other = (Plant) object;
        if ((this.idPLANT == null && other.idPLANT != null) || (this.idPLANT != null && !this.idPLANT.equals(other.idPLANT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "plantgrower.Plant[ idPLANT=" + idPLANT + " ]";
    }
    
}
