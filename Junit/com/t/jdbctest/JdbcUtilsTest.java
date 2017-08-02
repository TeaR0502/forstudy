package com.t.jdbctest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.t.jdbc.JdbcUtils;

public class JdbcUtilsTest {

	@Test
	public void testGetCurrentSession() {
		System.out.println(JdbcUtils.getCurrentSession());
	}

	@Test
	public void testOpenSession() {
		System.out.println(JdbcUtils.openSession());
	}

}
