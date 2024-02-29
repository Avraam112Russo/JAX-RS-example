package com.example.restjakartaapiexample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

@WebServlet(value = "/client")
public class ClientServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://localhost:8080/rest-jakarta-api-example-1.0-SNAPSHOT/api/testing");
//        Invocation invocation = target.path("22").request().buildGet();
//        Response response = invocation.invoke();
//        if (response.getStatusInfo().getStatusCode() == Response.Status.OK.getStatusCode()){
//            resp.getWriter().write(response.readEntity(String.class));
//        }
//        client.close();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/rest-jakarta-api-example-1.0-SNAPSHOT/api/testing/name");
        Invocation request = webTarget.queryParam("name", "Russo").request(MediaType.TEXT_PLAIN_TYPE).buildGet(); // build get method
        Response response = request.invoke();
        if (response.getStatusInfo().getStatusCode() == Response.Status.OK.getStatusCode()){
            resp.getWriter().write(response.readEntity(String.class));
        }
        client.close();
    }
}
