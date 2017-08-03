package com.t.dao;


import java.util.List;

import com.t.entity.Car;

public interface CarDAO {
	
	/**
	 * 模糊查询
	 * @return
	 */
	List<Car> vagueQuery(String info);
	/**
	 * 根据车辆的名称查询车辆信息
	 * @param name
	 * @return
	 */
	Car queryCarByName(String name);
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
