package com.t.serviceimpl;


import com.alibaba.fastjson.JSON;
import com.t.daoimpl.CategoryDAOimpl;
import com.t.entity.Category;
import com.t.service.CategoryService;

public class CategoryServiceimpl implements CategoryService{

	private static CategoryServiceimpl categoryServiceimpl;
	
	static {
		categoryServiceimpl = new CategoryServiceimpl();
	}
	
	public static  CategoryServiceimpl getNew() {
		return categoryServiceimpl;
	}

	@Override
	public String queryAllParent() {
		
		return JSON.toJSONString(CategoryDAOimpl.getNew().queryAllParentId());
	}

	@Override
	public boolean addCategory(String name, String parentCategory) {
		if (CategoryDAOimpl.getNew().queryCategoryByName(name) != null) {
			return false;
		} else {
			Category category = null;
			if (parentCategory != null || !parentCategory.equals("根目录")) {
				category = CategoryDAOimpl.getNew().queryCategoryByName(parentCategory);
			}
			Category newCategory = new Category();
			newCategory.setName(name);
			newCategory.setParentCatepory(category);
			CategoryDAOimpl.getNew().addCategory(newCategory);
			return true;
		}
		
		
		
	}

	@Override
	public String queryAllChild(String parentCatepory) {
		return JSON.toJSONString(CategoryDAOimpl.getNew().queryAllChildId(parentCatepory));
	}
	
	
	
	

}
