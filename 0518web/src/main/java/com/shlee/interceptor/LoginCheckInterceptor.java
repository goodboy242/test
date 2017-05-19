package com.shlee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("-----board preHandle-----");
		HttpSession session = request.getSession(false);
		String requestPage = request.getRequestURL().toString();
		String loginPage = "../login";
		Boolean loginStatus = false;
		System.out.println(requestPage);
		
		if (session == null) {
			request.getSession().setAttribute("requestPage", requestPage);
			response.sendRedirect(loginPage);
			return false;
		}
		
		loginStatus = (Boolean) request.getSession().getAttribute("loginStatus");
		System.out.println(loginStatus);
		System.out.println(false);
		if (!loginStatus) {
			request.getSession().setAttribute("requestPage", requestPage);
			response.sendRedirect(loginPage);
			return false;
		}
		return true;
	}

}
