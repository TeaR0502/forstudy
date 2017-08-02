package com.t.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.t.serviceimpl.UserServiceimpl;

public class UserAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2021288157321726888L;

	public String userLogin() {
		System.out.println("成功访问ACTION");
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("用户名为:"+username);
		System.out.println("密码为:"+password);
		if (UserServiceimpl.getNew().userLogin(username, password)) {
			request.getSession().setAttribute("user", username);
			System.out.println("登陆成功!");
			return SUCCESS;
		}else {
			System.out.println("登陆失败!");
			return "fail";
		}
	}
	
}
