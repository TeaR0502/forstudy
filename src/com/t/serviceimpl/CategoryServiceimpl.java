package com.t.serviceimpl;


import com.alibaba.fastjson.JSON;
import com.t.daoimpl.CategoryDAOimpl;
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
	
	
	
	

}
