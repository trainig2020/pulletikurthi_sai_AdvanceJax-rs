package com.satya.jaxrs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParm}/test")

public class Myresource {
 @PathParam("pathParm") private String pathParmExample;
 @QueryParam("query") private String queryParmExample;
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		
		return"it worked for partparm"+pathParmExample+"query parm value"+queryParmExample;
	}
}
