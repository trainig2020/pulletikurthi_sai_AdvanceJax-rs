package com.satya.jaxrs.resource.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.satya.jaxrs.messenger.model.Message;

public class RestApiClient {
public static void main(String[] args) {
	Client client=ClientBuilder.newClient();
	String message=client
			.target("http://localhost:8080/advancejaxrs/webapi/messages/1")
			.request()
			//.get(Message.class);
			.get(String.class);
	//Message message=response.readEntity(Message.class);
	//System.out.println(message.getMessage());
	System.out.println(message);
	
}
}
