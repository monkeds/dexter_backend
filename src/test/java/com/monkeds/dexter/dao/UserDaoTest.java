package com.monkeds.dexter.dao;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.monkeds.dexter.entity.User;

public class UserDaoTest {

	private static UserDAO userDAO;

	@BeforeClass
	public static void setup() {
		userDAO = new UserDAO();
	}

	@AfterClass
	public static void teardown() {
		userDAO = null;
	}

//	@Test
	public void testGetUserById() {
		User user = null;
		try {
			user = userDAO.getById("MONKED");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(user);
		System.out.println(user);
	}
	
	
	@Test
	public void testGetUserByCredentials() {
		User user = null;
		try {
			user = userDAO.getByCredentials(new User("medient@hotmail.com","1234"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(user);
		System.out.println(user);
	}
}
