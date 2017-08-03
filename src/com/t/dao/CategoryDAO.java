package com.t.dao;

import java.util.List;

import com.t.entity.Category;

public interface CategoryDAO {
	/**
	 * 根据名称查询该品牌
	 * @return
	 */
	Category queryCategoryByName(String name);
	/**
	 * 查询所有的父类品牌信息
	 * @return
	 */
	List<Category> queryAllParentId();
	/**
	 * 添加品牌信息
	 * @return
	 */
	int addCategory(Category category);
}
