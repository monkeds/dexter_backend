package com.monkeds.dexter_backend.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.monkeds.dexter_backend.dao.UserDAO;
import com.monkeds.dexter_backend.entity.User;
import com.monkeds.dexter_backend.service.UserService;
import com.monkeds.dexter_backend.utilities.ResultMessage;


@Path("users")
public class SimpleUserService implements UserService{
	
	
	UserDAO userDAO = new UserDAO();
	
//	@Override
//	@GET
//	@Path("/credentials")
//	@Produces(MediaType.APPLICATION_JSON)
//	public User getByCredentials(@QueryParam("email")String email,
//			@QueryParam("password") String password){
//		User result;
//		try{
//			result = userDAO.getByCredentials(email,password);
//		}catch(Exception e){
//			result = null;
//		}		
//		if(result==null){
//			throw new RuntimeException("Get: Todo with " + email +  " not found");
//		}
//		return result;
//		
//	}
//	
	
	@Override
	@GET
	@Path("/credentials")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByCredentials(@QueryParam("email")String email,
			@QueryParam("password") String password){
		User result = null;
		try{
			result = userDAO.getByCredentials(email,password);
		}catch(Exception e){
//			e.printStackTrace();
			return Response.serverError().entity(new ResultMessage(500,"El sistema no pudo procesar la solicitud")).build();
		}
		
		if(result != null){
			result.setCode(200);
			result.setMessage("Se obtuvo 1 resultado");
			return Response.ok().entity(result).build();
		}else{
			return Response.ok().entity(new ResultMessage(204,"No existe un usuario con estas credenciales")).build();
		}
		
	}
	

	@Override
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getById(@PathParam("id")String id) {
		try {
			return userDAO.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	

}
