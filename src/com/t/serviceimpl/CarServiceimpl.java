package com.t.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.t.dao.CarDAO;
import com.t.dao.CategoryDAO;
import com.t.entity.Car;
import com.t.entity.Category;
import com.t.service.CarService;

@Service
public class CarServiceimpl implements CarService{

	@Autowired
	private  CategoryDAO categoryDAO;
	@Autowired
	private  CarDAO carDAO ;
	
	
	
	@Override
	public String allCar() {
		List<Car> cars = carDAO.queryAll();
		return JSON.toJSONString(cars);
	}



	@Override
	public boolean checkName(String name) {
		if (carDAO.queryCarByName(name) == null) {
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
			Category category1 = categoryDAO.queryCategoryByName(category);
			car.setCategory(category1);
			carDAO.addCar(car);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}



	@Override
	public String vagueQuery(String info) {
		List<Car> cars = carDAO.vagueQuery(info);
		return JSON.toJSONString(cars);
	}

}
