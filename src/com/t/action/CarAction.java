package com.t.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.t.serviceimpl.CarServiceimpl;

public class CarAction extends ActionSupport{
	
	public void vagueQuery() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String info = request.getParameter("info");
		
		String carListJson = CarServiceimpl.getNew().vagueQuery(info);
		//System.out.println(carListJson);
		if (carListJson != null && carListJson.length() != 0) {
			response.getWriter().write(carListJson);
		} else {
			response.getWriter().write("");
		}
	}
	
	public String  checkCarName() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String name = request.getParameter("name");
		if (CarServiceimpl.getNew().checkName(name)) {
			//System.out.println("可以使用");
			response.getWriter().write("0");//可以使用没有重复
		} else {
			//System.out.println("重复");
			response.getWriter().write("1");//有重复名称
		}
		return null;
	}
	
	
	public String addCarInfo() throws IOException {
		System.out.println("添加车辆信息!");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String name = request.getParameter("name");
		Double price;
		try {
			price = Double.parseDouble(request.getParameter("price"));
		} catch (Exception e) {
			price = 0.0;
		}
		
		String color = request.getParameter("color");
		
		if (CarServiceimpl.getNew().addCar(name, price, color)) {
			System.out.println("成功");
			response.getWriter().write("0");//成功
		} else {
			System.out.println("失败");
			response.getWriter().write("1");//失败
		}
		return null;
	}
	
	public String  addcar() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if ("admin".equals(session.getAttribute("user"))) {
			return SUCCESS;
		} else {
			System.out.println("没有权限");
			return ERROR;
		}
		
	}
	
	
	
	public String allCar() throws IOException {
		System.out.println("调用ACTION");
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String carListJson = CarServiceimpl.getNew().allCar();
		//System.out.println(carListJson);
		if (carListJson != null && carListJson.length() != 0) {
			response.getWriter().write(carListJson);
			return null;
		} else {
			response.getWriter().write("");
			return null;
		}
		
	}
}
