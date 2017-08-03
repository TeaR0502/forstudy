package com.t.serviceimpl;

import com.t.daoimpl.UserDAOimpl;
import com.t.entity.Users;
import com.t.service.UserService;

public class UserServiceimpl implements UserService{
	private static UserServiceimpl userServiceimpl;
	
	static {
		userServiceimpl = new UserServiceimpl();
	}
	
	public static  UserServiceimpl getNew() {
		return userServiceimpl;
	}

	@Override
	public boolean userLogin(String username, String password) {
		Users users = UserDAOimpl.getNew().queryUserByName(username);
		if (users != null && users.getPassword().equals(password)) {
			System.out.println("密码正确");
			return true;
		} else {
			System.out.println("密码错误");
			return false;
		}
		
	}
	
}
