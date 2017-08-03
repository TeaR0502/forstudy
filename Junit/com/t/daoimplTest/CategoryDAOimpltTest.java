package com.t.daoimplTest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.t.dao.CategoryDAO;
import com.t.daoimpl.CategoryDAOimpl;
import com.t.entity.Category;
import com.t.jdbc.JdbcUtils;

public class CategoryDAOimpltTest {
	Session session=JdbcUtils.openSession();

	
	@Test
	public void testQueryAllChildId() {
		List< Category> categories = CategoryDAOimpl.getNew().queryAllChildId("宝马");
		for (Category category2 : categories) {
			System.out.println(category2);
		}
	}
	@Test
	public void testQueryCategoryByName() {
		System.out.println(CategoryDAOimpl.getNew().queryCategoryByName("宝马"));
	}
	
	@Test
	public void testQueryAllParentId() {
		List< Category> categories = CategoryDAOimpl.getNew().queryAllParentId();
		for (Category category2 : categories) {
			System.out.println(category2);
		}
	}
	
	@Test
	public void testAddCategory() {
		Query query = session.createQuery("from Category where name = '奔驰G系'");
		List<Category> category = query.list();
		for (Category category2 : category) {
			System.out.println(category2);
		}
		
		//Category category1 = new Category();
		//category1.setName("奔驰G系");
		//category1.setParentCatepory(category);
		//CategoryDAOimpl.getNew().addCategory(category1);
	}

}
