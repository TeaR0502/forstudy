package com.t.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t.dao.UserDAO;
import com.t.daoimpl.UserDAOimpl;
import com.t.entity.Users;
import com.t.service.UserService;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	private UserDAO userDAO ;
	
	@Override
	public boolean userLogin(String username, String password) {
		Users users = userDAO.queryUserByName(username);
		if (users != null && users.getPassword().equals(password)) {
			System.out.println("密码正确");
			return true;
		} else {
			System.out.println("密码错误");
			return false;
		}
		
	}
	
}
