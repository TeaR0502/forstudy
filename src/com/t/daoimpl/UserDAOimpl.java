package com.t.daoimpl;

import com.t.dao.UserDAO;
import com.t.entity.Users;

public class UserDAOimpl implements UserDAO {

	@Override
	public Users queryUserByName() {
		final String hql = "from Users where username = :name";
		return null;
	}

}
