package com.t.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.t.dao.UserDAO;
import com.t.entity.Users;

@Repository
public class UserDAOimpl implements UserDAO {
	
	private Session session;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		session = sessionFactory.openSession();
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
