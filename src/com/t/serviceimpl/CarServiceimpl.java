package com.t.serviceimpl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.t.daoimpl.CarDAOimpl;
import com.t.daoimpl.CategoryDAOimpl;
import com.t.entity.Car;
import com.t.entity.Category;
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



	@Override
	public boolean checkName(String name) {
		if (CarDAOimpl.getNew().queryCarByName(name) == null) {
			return true;
		} else {
			return false;
		}
		
	}



	@Override
	public boolean addCar(String name, Double price, String color,String category) {
		try {
			Car car = new Car();
			car.setColor(color);;
			car.setName(name);
			car.setPrice(price);
			Category category1 = CategoryDAOimpl.getNew().queryCategoryByName(category);
			car.setCategory(category1);
			CarDAOimpl.getNew().addCar(car);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}



	@Override
	public String vagueQuery(String info) {
		List<Car> cars = CarDAOimpl.getNew().vagueQuery(info);
		return JSON.toJSONString(cars);
	}

}
