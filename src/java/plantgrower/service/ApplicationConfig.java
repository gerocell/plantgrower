/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantgrower.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Jérôme
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(plantgrower.service.GrowthLogFacadeREST.class);
        resources.add(plantgrower.service.LocationFacadeREST.class);
        resources.add(plantgrower.service.MeasureFacadeREST.class);
        resources.add(plantgrower.service.ModuleFacadeREST.class);
        resources.add(plantgrower.service.NewMeasureREST.class);
        resources.add(plantgrower.service.PlantFacadeREST.class);
        resources.add(plantgrower.service.RequestupdateREST.class);
        resources.add(plantgrower.service.SensorFacadeREST.class);
    }
    
}
