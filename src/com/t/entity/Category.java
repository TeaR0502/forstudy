package com.t.entity;

import java.util.Set;

public class Category {
	private long categoryId;
	private String name ;
	private Category parentCatepory;
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getParentCatepory() {
		return parentCatepory;
	}
	public void setParentCatepory(Category parentCatepory) {
		this.parentCatepory = parentCatepory;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", parentCatepory=" + parentCatepory
				+ "]";
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(long categoryId, String name, Category parentCatepory, Set<Category> childCatepory) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.parentCatepory = parentCatepory;
	}
	
}
