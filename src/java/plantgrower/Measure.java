/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantgrower;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jérôme
 */
@Entity
@Table(name = "measure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Measure.findAll", query = "SELECT m FROM Measure m"),
    @NamedQuery(name = "Measure.findByIdMEASURE", query = "SELECT m FROM Measure m WHERE m.idMEASURE = :idMEASURE"),
    @NamedQuery(name = "Measure.findByValue", query = "SELECT m FROM Measure m WHERE m.value = :value"),
    @NamedQuery(name = "Measure.findByMeasureTime", query = "SELECT m FROM Measure m WHERE m.measureTime = :measureTime")})
public class Measure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMEASURE")
    private Integer idMEASURE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALUE")
    private float value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEASURE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measureTime;
    @JoinColumn(name = "SENSOR_idSENSOR", referencedColumnName = "idSENSOR")
    @ManyToOne(optional = false)
    private Sensor sENSORidSENSOR;

    public Measure() {
    }

    public Measure(Integer idMEASURE) {
        this.idMEASURE = idMEASURE;
    }

    public Measure(Integer idMEASURE, long value, Date measureTime) {
        this.idMEASURE = idMEASURE;
        this.value = value;
        this.measureTime = measureTime;
    }

    public Integer getIdMEASURE() {
        return idMEASURE;
    }

    public void setIdMEASURE(Integer idMEASURE) {
        this.idMEASURE = idMEASURE;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(Date measureTime) {
        this.measureTime = measureTime;
    }

    public Sensor getSENSORidSENSOR() {
        return sENSORidSENSOR;
    }

    public void setSENSORidSENSOR(Sensor sENSORidSENSOR) {
        this.sENSORidSENSOR = sENSORidSENSOR;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMEASURE != null ? idMEASURE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Measure)) {
            return false;
        }
        Measure other = (Measure) object;
        if ((this.idMEASURE == null && other.idMEASURE != null) || (this.idMEASURE != null && !this.idMEASURE.equals(other.idMEASURE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "plantgrower.Measure[ idMEASURE=" + idMEASURE + " ]";
    }
    
}
