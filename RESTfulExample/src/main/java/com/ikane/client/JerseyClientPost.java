/**
 * 
 */
package com.ikane.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author IKANE
 *
 */
public class JerseyClientPost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String url = "http://localhost:8080/RESTfulExample/rest/json/metallica/post";
		
		Client client = Client.create();
		
		WebResource webResource = client.resource(url);
		
		String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
		
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
		
		if(response.getStatus()!=200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);
	}
}
