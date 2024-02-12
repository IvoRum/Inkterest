package com.ink.auth;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/auth")
public class UserAuthenticationController {
    @GET
    @Path("/helloWorld")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World!";
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String logIn(UserLogIn request) {
        return "Hello World!";
    }

    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    public String register() {
        return "Hello World!";
    }
}
