package com.t.dao;


import java.util.List;

import com.t.entity.Car;

public interface CarDAO {
	
	
	/**
	 * 添加车辆信息
	 * @param car
	 * @return
	 */
	void addCar(Car car);	
	/**
	 * 查询出所有车辆
	 * @return
	 */
	List<Car> queryAll();
}
