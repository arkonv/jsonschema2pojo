package ru.smartsarov.jsonschema2pojo;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.TEXT_HTML + ";charset=UTF-8")
public class JsonSchema2PojoService {
	
	@GET
	@Path("/{packageName}/{className}")
    public Response generate(@PathParam("packageName") String packageName, @PathParam("className") String className, @DefaultValue("false") @QueryParam("dir") boolean dir) {
		String result = null;
		
		try {
			result = new JsonSchema2Pojo().json2Java(className, packageName, dir);
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
		}
    	
		return Response.status(Response.Status.OK).entity(result).build();
    }
	
	@GET
	@Path("/")
    public Response index() {
		try(InputStream is = this.getClass().getResourceAsStream("/static/index.html")) {
			return Response.status(Response.Status.OK).entity(is).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
}