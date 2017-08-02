package com.t.UserServiceimplTest;


import org.junit.Test;

import com.t.serviceimpl.UserServiceimpl;

public class UserServiceimplTset {

	@Test
	public void testUserLogin() {
		System.out.println(UserServiceimpl.getNew().userLogin("admin", "12356"));
	}

}
