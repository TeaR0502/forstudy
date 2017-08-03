package com.t.daoimplTest;


import java.util.List;

import org.junit.Test;

import com.t.daoimpl.CarDAOimpl;
import com.t.entity.Car;

public class CarDAOimplTest {

	@Test
	public void testVagueQuery() {
		List<Car> car = CarDAOimpl.getNew().vagueQuery("红");
		for (Car car2 : car) {
			System.out.println(car2);
		}
		
	}
	
	@Test
	public void testQueryCarByName() {
		Car car = CarDAOimpl.getNew().queryCarByName("宝123马");
		System.out.println(car);
	}
	
	
	@Test
	public void testQueryAll() {
		List<Car> cars = CarDAOimpl.getNew().queryAll();
		for (Car car : cars) {
			System.out.println(car);
		}
	}

	@Test
	public void testAddCar() {
		Car car = new Car(39.0,"奔驰","黑色");
		CarDAOimpl.getNew().addCar(car);
	}

}
