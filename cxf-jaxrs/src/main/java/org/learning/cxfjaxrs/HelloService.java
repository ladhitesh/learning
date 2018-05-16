package org.learning.cxfjaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

public class HelloService {
	
	@GET
	@Path("/hello/{name}")
    @Produces({"application/xml","application/json","text/html"})
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
	public String sayHello(@PathParam("name") String name){
		return "Hello "+name + "!!!";
	}


}
