package com.konak.service;
import com.konak.dao.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.konak.bean.KonakLoginCredentialsTb;
import com.konak.bean.KonakUserDetailsTb;
import com.konak.dao.RegisterDAO;
@Path("/login")
public class LoginService {
	LoginDAO dao = new LoginDAO();
	/*@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public KonakLoginCredentialsTb find(@PathParam("id") int id) {
		return dao.load(id);
	}*/
}
