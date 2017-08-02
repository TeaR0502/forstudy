package com.t.dao;


import com.t.entity.Users;

public interface UserDAO {
	
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	Users queryUserByName(String username);
	
	/**
	 * 添加用户信息
	 * @param users
	 * @return
	 */
	void addUser(Users users);
}
