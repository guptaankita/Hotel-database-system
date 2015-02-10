package com.konak.service;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/status")
public class Test {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String returnTitle() {
		return "<p>Mansoor Ahmed khan</p>";
	}
}

