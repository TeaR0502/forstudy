package com.t.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class JdbcUtils {
	private static Session session;
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		System.out.println(openSession());
	}
	static {
		//1.加载hibernate配置文件
		Configuration cfg = new Configuration().configure();
		//2.解析配置文件，生成SessionFactory
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			.applySettings(cfg.getProperties()).build();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	}
	
	/**
	 * 获取一个线程相关的session对象
	 * @return
	 */
	public static Session getCurrentSession() {
		session = sessionFactory.getCurrentSession();
		return session;
	}
	
	/**
	 * 获取一个新的session对象
	 * @return
	 */
	public static Session openSession() {
		if (session ==null || !session.isOpen() ) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
}
