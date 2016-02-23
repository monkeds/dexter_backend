package com.monkeds.dexter.mappers;

import com.monkeds.dexter.entity.User;

public interface UserMapper {
	public User getById(String id);
	
	public User getByCredentials(User user);
	
	public void insert(User user);
	
	public void update(User user);
}
