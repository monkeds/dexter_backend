package com.monkeds.dexter.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.monkeds.dexter.entity.Room;

public class RoomDAOTest {

	private static RoomDAO roomDAO;
	
	@BeforeClass
	public static void setup() {
		roomDAO = new RoomDAO();
	}

	@AfterClass
	public static void teardown() {
		roomDAO = null;
	}
	
	@Test
	public void testGetByUserId() {
		List<Room> rooms = null;
		try {
			rooms = roomDAO.getByUserId("MONKED");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(rooms);
		System.out.println(rooms);
	}
}
