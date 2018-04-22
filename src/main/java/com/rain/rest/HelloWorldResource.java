package com.rain.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * 资源类
 * @author rain
 * created on 2018/4/22
 */
@Path(value = "/helloWorld")
public class HelloWorldResource {

    @GET
    @Produces("text/plain")
    public String getHelloWorld() {
        return "HelloWorld";
    }
}