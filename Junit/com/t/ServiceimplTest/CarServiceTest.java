package com.t.ServiceimplTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.t.service.CarService;
import com.t.serviceimpl.CarServiceimpl;

public class CarServiceTest {

	@Test
	public void testAllCar() {
		System.out.println(CarServiceimpl.getNew().allCar());
	}

}
