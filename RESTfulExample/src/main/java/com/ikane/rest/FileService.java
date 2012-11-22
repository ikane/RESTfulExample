/**
 * 
 */
package com.ikane.rest;

import java.io.File;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.io.FileUtils;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * @author IKANE
 *
 */
@Path("file")
public class FileService {

	private static final String FILE_PATH = "c:\\file.log";
	
	@GET @Path("getLog")
	@Produces("text/plain")
	public Response getFile() {
		File file = new File(FILE_PATH);
		ResponseBuilder response = Response.ok(file);
		response.header("Content-Disposition", "attachment; filename=\"file_from_server.log\"");
		return response.build();
	}
	
	@POST @Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile (
			@FormDataParam("file") InputStream uploadedInputStream, 
			@FormDataParam("file") FormDataContentDisposition fileDetail) throws Exception  {
		String uploadedFileLocation = "c:\\uploaded\\" + fileDetail.getFileName();
		
		File uploadedFile = new File(uploadedFileLocation);
		
		//save it
		FileUtils.copyInputStreamToFile(uploadedInputStream, uploadedFile);
		
		String output = "File uploaded to : " + uploadedFileLocation;
		
		return Response.status(200).entity(output).build();
	}
}
