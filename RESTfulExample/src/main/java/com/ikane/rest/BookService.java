/**
 * 
 */
package com.ikane.rest;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author IKANE
 *
 */
@Path("books")
public class BookService {

	@GET
	public Response getBooks() {
		String msg = "gettting book for 2012...";
		return Response.status(200).entity(msg).build();
	}
	
	@GET @Path("{year}")
	public Response getBooks(
			@PathParam("year") String year, 
			@MatrixParam("author") String author, 
			@MatrixParam("country") String country) {
		String msg = "getBooks is called, year:" + year + ", author:" + author + ", country:" + country;
		return Response.status(200).entity(msg).build();
	}
}
