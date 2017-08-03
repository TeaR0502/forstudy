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

	
	
	public void addCategporyInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String name = request.getParameter("name");
		String parentCategory = request.getParameter("parentCategory");
		
		
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
		HttpSession session = ServletActionContext.getRequest().getSession();
		if ("admin".equals(session.getAttribute("user"))) {
			return SUCCESS;
		} else {
			System.out.println("没有权限");
			return ERROR;
		}
	}
}
