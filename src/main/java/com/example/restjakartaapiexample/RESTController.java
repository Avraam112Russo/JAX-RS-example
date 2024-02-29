package com.example.restjakartaapiexample;

import jakarta.enterprise.inject.Default;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.headers.Header;

@Path("/testing")
public class RESTController {

    @GET
    @Produces("text/plain")
    public String test(){
        System.out.println("rest controller handle request...");
        return "hello";
    }
    @GET
    @Produces("text/plain")
    @Path("{id}")
    public String handleId(@DefaultValue("defaultID")@PathParam("id") String id){
        System.out.println("Sent request with id: " + id);
        return "Sent request with id: " + id;
    }
    @GET
    @Produces("text/plain")
    @Path("/name")
    public String handleQueryParam(@DefaultValue("defaultName") @QueryParam("name")String name){
        return "Handle some request with name: " + name;
    }
    @GET
    @Produces("text/plain")
    @Path("/testHeader")
    public String handleHeader(@HeaderParam("someHeader")String someHeader){
        return "handle header: "+someHeader;
    }
    @GET
    @Path("/cookie")
    public String handleCookie(@CookieParam("token")String token){
        return "some handle cookie: "+token;
    }
}
