package com.monkeds.dexter_backend.mappers;

import java.util.List;

import com.monkeds.dexter_backend.entity.Room;


public interface RoomMapper {
	public List<Room> getByUserId(String userid);
	
}
