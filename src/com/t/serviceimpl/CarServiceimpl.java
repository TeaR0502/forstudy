package com.t.serviceimpl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.t.daoimpl.CarDAOimpl;
import com.t.entity.Car;
import com.t.service.CarService;

public class CarServiceimpl implements CarService{

	private static CarServiceimpl carServiceimpl;
	
	static {
		carServiceimpl = new CarServiceimpl();
	}
	
	public static  CarServiceimpl getNew() {
		return carServiceimpl;
	}
	
	
	
	@Override
	public String allCar() {
		List<Car> cars = CarDAOimpl.getNew().queryAll();
		return JSON.toJSONString(cars);
	}

}
