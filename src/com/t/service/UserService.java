package com.t.service;

public interface UserService {
	
	/**
	 * 根据用户名和密码判断用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	boolean userLogin(String username,String password) ;
}
