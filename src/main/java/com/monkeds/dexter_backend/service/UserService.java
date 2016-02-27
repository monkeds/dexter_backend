package com.monkeds.dexter_backend.service;

import javax.ws.rs.core.Response;

import com.monkeds.dexter_backend.entity.User;

public interface UserService {
	
	public Response getByCredentials(String email,String password);
	
	public Response insert(String nick,String email,String password,String state);

	public User getById(String id);

}
