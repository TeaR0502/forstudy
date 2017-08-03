package com.t.service;

public interface CategoryService {
	
	
	/**
	 * 查询父类品牌的子品牌
	 * 
	 * @return 返回json格式的字符串
	 */
	String queryAllChild(String parentCatepory);
	/**
	 * 添加一个Category对象进数据库
	 * @param name
	 * @param parentCategory
	 * @return
	 */
	boolean addCategory(String name,String parentCategory);
	/**
	 * 查询所有的父类品牌
	 * 
	 * @return 返回json格式的字符串
	 */
	String queryAllParent();
}
