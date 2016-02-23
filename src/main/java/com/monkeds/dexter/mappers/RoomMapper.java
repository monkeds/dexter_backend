package com.monkeds.dexter.mappers;

import java.util.List;

import com.monkeds.dexter.entity.Room;


public interface RoomMapper {
	public List<Room> getByUserId(String userid);
	
}
