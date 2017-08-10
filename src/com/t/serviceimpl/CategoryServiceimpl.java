package com.t.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.t.dao.CategoryDAO;
import com.t.daoimpl.CategoryDAOimpl;
import com.t.entity.Category;
import com.t.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService{

	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@Override
	public String queryAllParent() {
		
		return JSON.toJSONString(categoryDAO.queryAllParentId());
	}

	@Override
	public boolean addCategory(String name, String parentCategory) {
		if (categoryDAO.queryCategoryByName(name) != null) {
			return false;
		} else {
			Category category = null;
			if (parentCategory != null || !parentCategory.equals("根目录")) {
				category = categoryDAO.queryCategoryByName(parentCategory);
			}
			Category newCategory = new Category();
			newCategory.setName(name);
			newCategory.setParentCatepory(category);
			categoryDAO.addCategory(newCategory);
			return true;
		}
		
		
		
	}

	@Override
	public String queryAllChild(String parentCatepory) {
		return JSON.toJSONString(categoryDAO.queryAllChildId(parentCatepory));
	}
	
	
	
	

}
