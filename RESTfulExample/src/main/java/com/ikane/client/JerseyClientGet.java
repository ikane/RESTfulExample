/**
 * 
 */
package com.ikane.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author IKANE
 *
 */
public class JerseyClientGet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/RESTfulExample/rest/json/metallica/get");
		
		ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
		
		if(clientResponse.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code :" + clientResponse.getStatus());
		}
		
		String output = clientResponse.getEntity(String.class);
		
		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}

}
