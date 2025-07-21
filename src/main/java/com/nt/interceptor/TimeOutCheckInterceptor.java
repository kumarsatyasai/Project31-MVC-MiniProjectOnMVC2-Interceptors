package com.nt.interceptor;

import java.time.LocalDateTime; 

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TimeOutCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		if(req.getServletPath().equalsIgnoreCase("/")) {
			return true;
		}
			
		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();
		if(hour>=9 && hour<=24) {
			
			return true;
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("/time_out.jsp");
			rd.forward(req, res);
			return false;
		}
	}

}
