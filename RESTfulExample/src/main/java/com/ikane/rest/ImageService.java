/**
 * 
 */
package com.ikane.rest;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * @author IKANE
 *
 */
@Path("images")
public class ImageService {

	@GET
	@Path("getImage")
	@Produces("image/png")
	public Response getImage() {
		File img = new File("c:\\wsdl.png");
		ResponseBuilder responseBuilder = Response.ok(img);
		responseBuilder.header("Content-Disposition", "attachment, filename=\"wsdl.png\"");
		return responseBuilder.build();
	}
}
