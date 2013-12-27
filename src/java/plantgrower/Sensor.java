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
@Table(name = "sensor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sensor.findAll", query = "SELECT s FROM Sensor s"),
    @NamedQuery(name = "Sensor.findByIdSENSOR", query = "SELECT s FROM Sensor s WHERE s.idSENSOR = :idSENSOR"),
    @NamedQuery(name = "Sensor.findBySensorIdString", query = "SELECT s FROM Sensor s WHERE s.sensorIdString = :sensorIdString"),
    @NamedQuery(name = "Sensor.findBySensorType", query = "SELECT s FROM Sensor s WHERE s.sensorType = :sensorType"),
    @NamedQuery(name = "Sensor.findBySensorTypeandModuleId", query = "SELECT s FROM Sensor s WHERE s.sensorType = :sensorType AND s.mODULEidMODULE = :moduleId"),
    @NamedQuery(name = "Sensor.findByModulePort", query = "SELECT s FROM Sensor s WHERE s.modulePort = :modulePort")})
public class Sensor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSENSOR")
    private Integer idSENSOR;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SENSOR_ID_STRING")
    private String sensorIdString;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SENSOR_TYPE")
    private String sensorType;
    @Column(name = "MODULE_PORT")
    private Integer modulePort;
    @JoinColumn(name = "PLANT_idPLANT", referencedColumnName = "idPLANT")
    @ManyToOne(optional = false)
    private Plant pLANTidPLANT;
    @JoinColumn(name = "MODULE_idMODULE", referencedColumnName = "idMODULE")
    @ManyToOne(optional = false)
    private Module mODULEidMODULE;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sENSORidSENSOR")
    private Collection<Measure> measureCollection;

    public Sensor() {
    }

    public Sensor(Integer idSENSOR) {
        this.idSENSOR = idSENSOR;
    }

    public Sensor(Integer idSENSOR, String sensorIdString, String sensorType) {
        this.idSENSOR = idSENSOR;
        this.sensorIdString = sensorIdString;
        this.sensorType = sensorType;
    }

    public Integer getIdSENSOR() {
        return idSENSOR;
    }

    public void setIdSENSOR(Integer idSENSOR) {
        this.idSENSOR = idSENSOR;
    }

    public String getSensorIdString() {
        return sensorIdString;
    }

    public void setSensorIdString(String sensorIdString) {
        this.sensorIdString = sensorIdString;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Integer getModulePort() {
        return modulePort;
    }

    public void setModulePort(Integer modulePort) {
        this.modulePort = modulePort;
    }

    public Plant getPLANTidPLANT() {
        return pLANTidPLANT;
    }

    public void setPLANTidPLANT(Plant pLANTidPLANT) {
        this.pLANTidPLANT = pLANTidPLANT;
    }

    public Module getMODULEidMODULE() {
        return mODULEidMODULE;
    }

    public void setMODULEidMODULE(Module mODULEidMODULE) {
        this.mODULEidMODULE = mODULEidMODULE;
    }

    @XmlTransient
    public Collection<Measure> getMeasureCollection() {
        return measureCollection;
    }

    public void setMeasureCollection(Collection<Measure> measureCollection) {
        this.measureCollection = measureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSENSOR != null ? idSENSOR.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensor)) {
            return false;
        }
        Sensor other = (Sensor) object;
        if ((this.idSENSOR == null && other.idSENSOR != null) || (this.idSENSOR != null && !this.idSENSOR.equals(other.idSENSOR))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "plantgrower.Sensor[ idSENSOR=" + idSENSOR + " ]";
    }
    
}
