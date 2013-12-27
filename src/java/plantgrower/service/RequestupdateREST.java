/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantgrower.service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Jérôme
 */
@Path("requestupdate")
public class RequestupdateREST {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RequestupdateREST
     */
    public RequestupdateREST() {
    }

    /**
     * Retrieves representation of an instance of plantgrower.service.RequestupdateREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "{{\"TEST1\", \"test1\"},{\"TEST2\",\"test2\"}}";
    }

    /**
     * PUT method for updating or creating an instance of RequestupdateREST
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
