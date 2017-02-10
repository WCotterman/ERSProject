package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.ERSDAO;
import com.revature.pojo.User;

public class LoginTest {

	@Test
	public void test() {
		ERSDAO dao = new ERSDAO();
		User user = dao.getUser("wcotterman");
		assertTrue(user.getFname().equals("wes"));
	}
	
	@Test
	public void testUname(){
		ERSDAO dao = new ERSDAO();
		assertTrue(dao.checkUsername("wcotterman") == 1);
	}
	
	@Test
	public void testPass(){
		ERSDAO dao = new ERSDAO();
		assertTrue(dao.getPassword("wcotterman").equals("pass"));
	}

}
