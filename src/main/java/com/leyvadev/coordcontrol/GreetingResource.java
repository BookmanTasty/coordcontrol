package com.leyvadev.coordcontrol;

import com.leyvadev.coordcontrol.dto.LoadCords;
import com.leyvadev.coordcontrol.model.PointOfInterest;
import com.leyvadev.coordcontrol.service.CoordControl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/api")
public class GreetingResource {

    @Inject
    CoordControl coordControl;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @POST
    @Path("/store")
    public PointOfInterest storePointOfInterest(LoadCords loadCords){
        return coordControl.storePointOfInterest(loadCords);
    }

    @GET
    @Path("/getall")
    public List<PointOfInterest> getPointsOfInterest(){
        return coordControl.getPointsOfInterest();
    }

    @DELETE
    @Path("/delete/{id}")
    public void deletePointOfInterest(@PathParam("id") UUID id){
        coordControl.deletePointOfInterest(id);
    }
}
