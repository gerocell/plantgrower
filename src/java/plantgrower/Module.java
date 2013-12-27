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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jérôme
 */
@Entity
@Table(name = "module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findByIdMODULE", query = "SELECT m FROM Module m WHERE m.idMODULE = :idMODULE"),
    @NamedQuery(name = "Module.findByNameModule", query = "SELECT m FROM Module m WHERE m.nameModule = :nameModule"),
    @NamedQuery(name = "Module.findByModuleLastupdate", query = "SELECT m FROM Module m WHERE m.moduleLastupdate = :moduleLastupdate"),
    @NamedQuery(name = "Module.findByModuleIdString", query = "SELECT m FROM Module m WHERE m.moduleIdString = :moduleIdString")})
public class Module implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMODULE")
    private Integer idMODULE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NAME_MODULE")
    private String nameModule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODULE_LASTUPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moduleLastupdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MODULE_ID_STRING")
    private String moduleIdString;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mODULEidMODULE")
    private Collection<Sensor> sensorCollection;

    public Module() {
    }

    public Module(Integer idMODULE) {
        this.idMODULE = idMODULE;
    }

    public Module(Integer idMODULE, String nameModule, Date moduleLastupdate, String moduleIdString) {
        this.idMODULE = idMODULE;
        this.nameModule = nameModule;
        this.moduleLastupdate = moduleLastupdate;
        this.moduleIdString = moduleIdString;
    }

    public Integer getIdMODULE() {
        return idMODULE;
    }

    public void setIdMODULE(Integer idMODULE) {
        this.idMODULE = idMODULE;
    }

    public String getNameModule() {
        return nameModule;
    }

    public void setNameModule(String nameModule) {
        this.nameModule = nameModule;
    }

    public Date getModuleLastupdate() {
        return moduleLastupdate;
    }

    public void setModuleLastupdate(Date moduleLastupdate) {
        this.moduleLastupdate = moduleLastupdate;
    }

    public String getModuleIdString() {
        return moduleIdString;
    }

    public void setModuleIdString(String moduleIdString) {
        this.moduleIdString = moduleIdString;
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
        hash += (idMODULE != null ? idMODULE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.idMODULE == null && other.idMODULE != null) || (this.idMODULE != null && !this.idMODULE.equals(other.idMODULE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "plantgrower.Module[ idMODULE=" + idMODULE + " ]";
    }
    
}
