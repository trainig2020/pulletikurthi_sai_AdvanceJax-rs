package com.satya.jaxrs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class Myresource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return"it worked";
	}
}
