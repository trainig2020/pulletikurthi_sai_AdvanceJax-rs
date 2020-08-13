package com.satya.jaxrs.resource.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.satya.jaxrs.messenger.model.Message;

public class RestApiClient {
public static void main(String[] args) {
	Client client=ClientBuilder.newClient();
	
	
	WebTarget target=client.target("http://localhost:8080/advancejaxrs/webapi/");
	WebTarget wbTarget=target.path("messages");
	WebTarget sTarget=wbTarget.path("{messageId}");
	
	
	Message message=(Message) sTarget
			.resolveTemplate("messageId","1")
			.request(MediaType.APPLICATION_JSON)
			.get(Message.class);
	
	
	Message message1=new Message(5, "Hellosai", "satya");
	   Response response=wbTarget
			.request()
			.post(Entity.json(message1));
			Message crMessage=response.readEntity(Message.class);
		
	System.out.println(crMessage.getMessage());
	
}
}
