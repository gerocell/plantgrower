/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantgrower.service;

import java.util.Date;
import javax.ejb.Stateless;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import plantgrower.Measure;
import plantgrower.Module;
import plantgrower.Sensor;

/**
 *
 * @author Jérôme
 */
@Stateless
@Path("/newmeasure")
public class NewMeasureREST {
    @PersistenceContext(unitName = "WebServiceTestPU")
    private EntityManager em;
    String moduleIdString;
    String measType;
    float measValue;
    
    public NewMeasureREST(){}
    
    @POST
    @Consumes("application/json")
    public Response postForm(JsonObject meas) throws JsonException, NoResultException {
        Measure newMeasure = new Measure();
        Integer maxIdMeasure;
        Module measModule; 
        Sensor measSensor;
    
        moduleIdString = meas.getString("module");
        measType = meas.getString("type");
        measValue = (float)meas.getJsonNumber("value").doubleValue();
    
        measModule = (Module)getEntityManager().createNamedQuery("Module.findByModuleIdString").setParameter("moduleIdString", moduleIdString).getSingleResult();
        measSensor = (Sensor)getEntityManager().createNamedQuery("Sensor.findBySensorTypeandModuleId").setParameter("sensorType", measType).setParameter("moduleId", measModule).getSingleResult();
        maxIdMeasure = (Integer)getEntityManager().createQuery("SELECT MAX(m.idMEASURE) FROM Measure m").getSingleResult();
        if (maxIdMeasure == null) {
            maxIdMeasure = new Integer(0);
        }
        
        newMeasure.setIdMEASURE(Integer.valueOf(maxIdMeasure.intValue()+1));
        newMeasure.setSENSORidSENSOR(measSensor);
        newMeasure.setValue(measValue);
        newMeasure.setMeasureTime(new Date());
  
        try {
            getEntityManager().persist(newMeasure);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
        
        
       
        return Response.ok().build();
    }
    
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
