package com.t.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.t.dao.CarDAO;
import com.t.dao.UserDAO;
import com.t.entity.Car;
import com.t.entity.Users;
import com.t.jdbc.JdbcUtils;

public class CarDAOimpl implements CarDAO {
	
	private static Session session;
	private static CarDAOimpl carDAOimpl ;
	

	
	static {
		session = JdbcUtils.openSession();
		carDAOimpl = new CarDAOimpl();
	}
	
	/**
	 * 单例模式
	 * @return
	 */
	public static CarDAOimpl getNew() {
		return carDAOimpl;
	}

	@Override
	public List<Car> queryAll() {
		final String hql = "from Car";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public void addCar(Car car) {
		session.save(car);
		session.beginTransaction().commit();
	}





	

}
