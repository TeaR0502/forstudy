package com.t.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpSession session = request2.getSession();
		String username = (String) session.getAttribute("user");
		System.out.println(username);
		if (username == null || "".equals(username)) {
			System.out.println("未登录");
			((HttpServletResponse) response).sendRedirect("index.jsp");
		}  else {
			chain.doFilter(request, response);
		}
		
	}
	
}
