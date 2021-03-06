package com.t.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.t.dao.CarDAO;
import com.t.dao.UserDAO;
import com.t.entity.Car;
import com.t.entity.Users;

@Repository
public class CarDAOimpl implements CarDAO {
	
	private Session session;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		session = sessionFactory.openSession();
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

	@Override
	public Car queryCarByName(String name) {
		final String hql = "from Car where name = :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		Car car = null;
		if (query.list() != null && query.list().size() != 0) {
			car = (Car) query.list().get(0);
		}
		return car;
	}

	@Override
	public List<Car> vagueQuery(String info) {
		Double price;
		try {
			price = Double.parseDouble(info);
		} catch (Exception e) {
			price = 0.0;
		}
		final String hql = "from Car where name like :name or price = :price or color like :color";
		Query query = session.createQuery(hql);
		info = "%"+info+"%";
		query.setParameter("name", info);
		
		query.setParameter("price", price);
		query.setParameter("color", info);
		return query.list();
	}





	

}
