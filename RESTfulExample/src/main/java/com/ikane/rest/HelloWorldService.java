/**
 * 
 */
package com.ikane.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


/**
 * @author IKANE
 *
 */
@Path("/hello")
public class HelloWorldService {

	@GET
	public Response getMsg() {
		String output = "Jersey says: Hello Mister!";
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		String output = "Jersey says: Hello Mister " + msg + "!";
		return Response.status(200).entity(output).build();
	}
}
