package com.t.service;

import java.util.List;

import com.t.entity.Car;

public interface CarService {
	
	/**
	 * 模糊查询
	 * @param info
	 * @return json格式字符串
	 */
	String  vagueQuery(String info);
	
	/**
	 * 添加车辆
	 * @param name
	 * @param price
	 * @param color
	 * @return
	 */
	boolean addCar(String name,Double price,String color,String category);
	/**
	 * 检验车辆的名称
	 * @return
	 */
	boolean checkName(String name);
	/**
	 * 查询所有车辆
	 * @return 返回值为JSON格式的LIST列表
 	 */
	String allCar();
}
