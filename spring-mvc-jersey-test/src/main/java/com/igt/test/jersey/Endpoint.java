package com.igt.test.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
@Produces("application/json")
public class Endpoint {

    @GET
    public TestDto message() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new TestDto("test1", "test2");
    }

}