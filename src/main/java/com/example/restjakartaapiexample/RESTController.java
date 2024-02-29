package com.example.restjakartaapiexample;

import jakarta.enterprise.inject.Default;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.Providers;
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
    @GET
    @Path("/JAXBTEST")
    @Produces(MediaType.APPLICATION_XML)
    public Employee getEmployee(@QueryParam("employee")String employeeName, @QueryParam("salary")int salary){
        Employee employee = new Employee();
        employee.setSalary(salary);
        employee.setName(employeeName);
        return employee;
    }
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeJson(@QueryParam("name")String name, @QueryParam("salary")int salary){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        return Response.ok(employee, MediaType.APPLICATION_JSON).build();
    }
    @GET
    @Path("/context")
    public Response fetchInfoFromContext(@Context Request request,
                                         @Context SecurityContext securityContext,
                                         @Context HttpHeaders httpHeaders, @Context Providers providers
    ){
        // some handling request
        return null;
    }
}
