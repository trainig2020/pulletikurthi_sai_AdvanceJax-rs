package com.satya.jaxrs.resource;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;
@Provider
public class SecureFilter implements ContainerRequestFilter {
  private static final String AUTHORIZATION_HEADER_KEY="Authorization";
  private static final String AUTHORIZATION_HEADER_PREFIX="Basic ";
  private static final String SECURED_URL_PREFIX="secured";
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
	List<String> authHeader=	requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		if(authHeader !=null &&  authHeader.size() >0) {
			String authToken=authHeader.get(0);
			authToken=authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodeString=Base64.decodeAsString(authToken);
			StringTokenizer tokenizer=new StringTokenizer(decodeString,":");
			String username=tokenizer.nextToken();
			String password=tokenizer.nextToken();
			
			if("user".equals(username)&& "password".equals(password)) {
				return;
			}
		}
		Response unauthorized=Response
				    .status(Response.Status.UNAUTHORIZED)
				    .encoding("You are not Authorized to Use")
				    .build();
		requestContext.abortWith(unauthorized);
		
	}

   }
}
