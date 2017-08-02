package com.t.dao;

import com.t.entity.Users;

public interface UserDAO {
	
	/**
	 * 根据用户名查询用户信息
	 * @return
	 */
	Users queryUserByName();
}
