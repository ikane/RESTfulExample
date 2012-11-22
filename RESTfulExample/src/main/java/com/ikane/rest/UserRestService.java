/**
 * 
 */
package com.ikane.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;


/**
 * @author IKANE
 *
 */
@Path("/users")
public class UserRestService {

	@GET
	public Response getUser() {
		return Response.status(Status.OK).entity("getUser() is called").build();
	}
	
	@GET
	@Path("/vip")
	public Response getUserVIP() {
		return Response.status(Status.OK).entity("getUserVIP() is called").build();
	}
	
	@GET
	@Path("/name/{name}")
	public Response getUserByName(@PathParam("name")String name) {
		return Response.status(Status.OK).entity("getUserByName is called, name:" + name).build();
	}
	
	@GET
	@Path("/id/{id:\\d+}")
	public Response getUserById(@PathParam("id")String id) {
		return Response.status(200).entity("getUserByName is called, id:" + id).build();
	}
	
	@GET
	@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
	public Response getUserByUserName(@PathParam("username") String username) {
	   return Response.status(200).entity("getUserByUserName is called, username : " + username).build();
	}
	
	@GET
	@Path("/books/{isbn : \\d+}")
	public Response getUserBookByISBN(@PathParam("isbn") String isbn) {
 
	   return Response.status(200)
		.entity("getUserBookByISBN is called, isbn : " + isbn).build();
 
	}
	
	@GET @Path("query")
	public Response getUsersWithParams(
			@DefaultValue("100") @QueryParam("from") int from, 
			@DefaultValue("999") @QueryParam("to") int to, 
			@DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {
		String msg = "getUsersWithParams is called, from " + from + ", to " + to + ", orderBy " + orderBy.toString();
		return Response.status(200).entity(msg).build();
	}
	
	@GET @Path("query2")
	public Response getUsersWithParams(@Context UriInfo info) {
		String from = StringUtils.defaultIfEmpty(info.getQueryParameters().getFirst("from"), "");
		String to = StringUtils.defaultIfEmpty(info.getQueryParameters().getFirst("to"), "");
		List<String> orderBy = info.getQueryParameters().get("orderBy");
		if(CollectionUtils.isEmpty(orderBy)) {
			orderBy = new ArrayList<String>();
		}
		
		String msg = "getUsersWithParams is called, from " + from + ", to " + to + ", orderBy " + orderBy.toString();
		return Response.status(200).entity(msg).build();
	}
	
	@POST @Path("add")
	public Response addUser(@FormParam("name")String name, @FormParam("age")int age) {
		String msg = "addUser is called, name : " + name + ", age : " + age;
		return Response.status(200).entity(msg).build();
	}
	
	@GET @Path("get")
	public Response getUser(@HeaderParam("user-agent")String userAgent) {
		String msg="getUser is called, userAgent:" + userAgent;
		return Response.status(200).entity(msg).build();
	}
	
	@GET @Path("get2")
	public Response getUser(@Context HttpHeaders httpHeaders) {
		for(String header : httpHeaders.getRequestHeaders().keySet()){
			System.out.println(header + ": " + httpHeaders.getRequestHeader(header).get(0));
		}
		String msg = "getUser is called, userAgent:" + httpHeaders.getRequestHeader("user-agent").get(0);
		return Response.status(200).entity(msg).build();
	}
	
}
