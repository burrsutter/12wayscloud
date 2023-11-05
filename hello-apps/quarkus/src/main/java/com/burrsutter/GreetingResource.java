package com.burrsutter;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/")
public class GreetingResource {

    int count;
    String greeting;
    boolean behave = true;
    boolean alive = true;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String root() {
      greeting = "Hola";
      count++;
      System.out.println(greeting + ": " + count);
      return greeting + " from Supersonic Subatomic Quarkus! " + count + "\n";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/health")
    public Response health() {
      if (behave) {
        return Response.ok("I am fine, thank you\n").build();
        } else {    
         return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity("Give me a moment\n").build();
      }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/alive")
    public Response alive() {
      if (alive) {
        return Response.ok("It's Alive! (Frankenstein)\n").build();
        } else {    
         return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity("All dead, not mostly dead (Princess Bride)\n").build();
      }
    }


    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    
}
