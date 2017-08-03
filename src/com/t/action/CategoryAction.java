package com.t.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.t.service.CategoryService;
import com.t.serviceimpl.CarServiceimpl;
import com.t.serviceimpl.CategoryServiceimpl;

public class CategoryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8086743104357144647L;

	
	
	
	/**
	 * 添加品牌信息
	 * @throws IOException
	 */
	public void addCategporyInfo() throws IOException {
		System.out.println("调用addCategoryInfo");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String name = request.getParameter("name");
		String parentCategory = request.getParameter("parentCategory");
		if (CategoryServiceimpl.getNew().addCategory(name, parentCategory)) {
			response.getWriter().write("0");//成功
		} else {
			response.getWriter().write("1");//存在同名类
		}
	}
	
	/**
	 * 查询父类下子类品牌
	 * @throws IOException 
	 */
	public void queryAllChild() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String parentCategory = request.getParameter("parentCategory");
		String categoryListJson = CategoryServiceimpl.getNew().queryAllChild(parentCategory);
		if (categoryListJson != null && categoryListJson.length() != 0) {
			response.getWriter().write(categoryListJson);
		} else {
			response.getWriter().write("");
		}	
	}
	
	/**
	 * 查询所有的父类品牌
	 * @return
	 * @throws IOException
	 */
	public String queryAllParent() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String categoryListJson = CategoryServiceimpl.getNew().queryAllParent();
		//System.out.println(carListJson);
		if (categoryListJson != null && categoryListJson.length() != 0) {
			response.getWriter().write(categoryListJson);
		} else {
			response.getWriter().write("");
		}
		return null;
	}
	
	/**
	 * 拦截器验证用户权限
	 * @return
	 */
	public String  getJsp() {
		System.out.println("调用成功");
		HttpSession session = ServletActionContext.getRequest().getSession();
		if ("admin".equals(session.getAttribute("user"))) {
			return SUCCESS;
		} else {
			System.out.println("没有权限");
			return ERROR;
		}
	}
}
