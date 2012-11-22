/**
 * 
 */
package com.ikane.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikane.model.Track;

/**
 * Service REST retournant un objet Track sous forme JSON
 * 
 * @author IKANE
 */
@Path("json/metallica")
public class JSONService {

	@GET @Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {
		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");
		
		return track;
	}
	
	@POST @Path("post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {
		String msg = "Track saved " + track;
		return Response.status(200).entity(msg).build();
	}
}
