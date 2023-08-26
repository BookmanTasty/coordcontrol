package com.leyvadev.coordcontrol.client;

import com.leyvadev.coordcontrol.dto.Root;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface GoogleMapsRest {
    @GET
    @Path("geocode/json")
    Root getByCords(@QueryParam("latlng") String latlng, @QueryParam("key") String key);
}


