package com.satya.jaxrs.resource;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
@Provider
public class LogginFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("request filter"+requestContext.getHeaders());
		
	}

}
