package com.t.daoimplTest;


import org.junit.Test;

import com.t.daoimpl.UserDAOimpl;
import com.t.entity.Users;

public class UserDAOimplTest {
	@Test
	public void testQueryUserByName() {
		System.out.println(UserDAOimpl.getNew().queryUserByName("T"));
	}
	
	@Test
	public void testAddUser() {
		Users users = new Users();
		users.setPassword("123456");
		users.setStatus(0);
		users.setUsername("admin");
		UserDAOimpl.getNew().addUser(users);
	}
	

}
