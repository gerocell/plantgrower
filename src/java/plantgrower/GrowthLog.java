/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantgrower;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jérôme
 */
@Entity
@Table(name = "growth_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrowthLog.findAll", query = "SELECT g FROM GrowthLog g"),
    @NamedQuery(name = "GrowthLog.findByIdGROWTHLOG", query = "SELECT g FROM GrowthLog g WHERE g.idGROWTHLOG = :idGROWTHLOG"),
    @NamedQuery(name = "GrowthLog.findByStartTime", query = "SELECT g FROM GrowthLog g WHERE g.startTime = :startTime")})
public class GrowthLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGROWTH_LOG")
    private Integer idGROWTHLOG;
    @Basic(optional = false)
    @NotNull
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gROWTHLOGidGROWTHLOG")
    private Collection<Plant> plantCollection;

    public GrowthLog() {
    }

    public GrowthLog(Integer idGROWTHLOG) {
        this.idGROWTHLOG = idGROWTHLOG;
    }

    public GrowthLog(Integer idGROWTHLOG, Date startTime) {
        this.idGROWTHLOG = idGROWTHLOG;
        this.startTime = startTime;
    }

    public Integer getIdGROWTHLOG() {
        return idGROWTHLOG;
    }

    public void setIdGROWTHLOG(Integer idGROWTHLOG) {
        this.idGROWTHLOG = idGROWTHLOG;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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
        hash += (idGROWTHLOG != null ? idGROWTHLOG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrowthLog)) {
            return false;
        }
        GrowthLog other = (GrowthLog) object;
        if ((this.idGROWTHLOG == null && other.idGROWTHLOG != null) || (this.idGROWTHLOG != null && !this.idGROWTHLOG.equals(other.idGROWTHLOG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "plantgrower.GrowthLog[ idGROWTHLOG=" + idGROWTHLOG + " ]";
    }
    
}
