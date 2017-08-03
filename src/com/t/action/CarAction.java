package com.t.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.t.serviceimpl.CarServiceimpl;

public class CarAction {
	
	
	public String allCar() throws IOException {
		System.out.println("调用ACTION");
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String carListJson = CarServiceimpl.getNew().allCar();
		System.out.println(carListJson);
		if (carListJson != null && carListJson.length() != 0) {
			response.getWriter().write(carListJson);
			return null;
		} else {
			response.getWriter().write("");
			return null;
		}
		
	}
}
