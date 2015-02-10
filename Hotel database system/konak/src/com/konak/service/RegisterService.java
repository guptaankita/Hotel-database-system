package com.konak.service;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.konak.bean.KonakUserDetailsTb;
import com.konak.dao.*;
@Path("/register")
public class RegisterService {
	/*RegisterDAO dao = new RegisterDAO();
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public KonakUserDetailsTb find(@PathParam("id") int id) {
		return dao.load(id);
	}
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public KonakUserDetailsTb create(KonakUserDetailsTb register) {
		return dao.save(register);
	}
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		dao.remove(id);
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(KonakUserDetailsTb user) {
		dao.update(user);
	}*/
}
