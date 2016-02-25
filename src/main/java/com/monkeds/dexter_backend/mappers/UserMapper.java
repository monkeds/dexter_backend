package com.monkeds.dexter_backend.mappers;

import java.util.Map;

import com.monkeds.dexter_backend.entity.User;

public interface UserMapper {
	public User getById(String id);
	
	public User getByCredentials(Map<String, String> credentials);
	
	public void insert(User user);
	
	public void update(User user);
}
