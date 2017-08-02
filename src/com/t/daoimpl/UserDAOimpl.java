package com.t.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.t.dao.UserDAO;
import com.t.entity.Users;
import com.t.jdbc.JdbcUtils;

public class UserDAOimpl implements UserDAO {
	
	private static Session session;
	private static UserDAOimpl userDAOimpl ;
	

	
	static {
		session = JdbcUtils.openSession();
		userDAOimpl = new UserDAOimpl();
	}
	
	/**
	 * 单例模式
	 * @return
	 */
	public static UserDAOimpl getNew() {
		return userDAOimpl;
	}





	@Override
	public Users queryUserByName(String username) {
		final String hql = "from Users where username = :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", username);
		return (Users) query.list().get(0);
	}





	@Override
	public void addUser(Users users) {
		session.save(users);
		session.beginTransaction().commit();
	}

}
