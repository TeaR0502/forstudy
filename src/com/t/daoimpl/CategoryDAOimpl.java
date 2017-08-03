package com.t.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sun.xml.internal.messaging.saaj.soap.StringDataContentHandler;
import com.t.dao.CategoryDAO;
import com.t.entity.Category;
import com.t.jdbc.JdbcUtils;

public class CategoryDAOimpl implements CategoryDAO{

	private static Session session;
	private static CategoryDAOimpl categoryDAOimpl ;
	

	
	static {
		session = JdbcUtils.openSession();
		categoryDAOimpl = new CategoryDAOimpl();
	}
	
	/**
	 * 单例模式
	 * @return
	 */
	public static CategoryDAOimpl getNew() {
		return categoryDAOimpl;
	}

	
	
	@Override
	public int addCategory(Category category) {
		
		try {
			session.save(category);
			session.beginTransaction().commit();
			return 0;
		} catch (Exception e) {
			return 1;
		}
	}



	@Override
	public List<Category> queryAllParentId() {
		final String hql = "from Category where parentCategory is null";
		Query query = session.createQuery(hql);
		return query.list();
	}



	@Override
	public Category queryCategoryByName(String name) {
		final String hql = "from Category where name = :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		return (Category) query.uniqueResult();
	}



	@Override
	public List<Category> queryAllChildId(String parentCategory) {
		final String hql = "from Category where parentCatepory = :parentCatepory";
		Category category = CategoryDAOimpl.getNew().queryCategoryByName(parentCategory);
		Query query = session.createQuery(hql);
		query.setParameter("parentCatepory", category);
		return query.list();
	}

}
