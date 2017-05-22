package com.shlee.interceptor;

import javax.servlet.RequestDispatcher;
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
		HttpSession session = request.getSession(false); //false 로 둬야 없을 때 새로 만들지 않
		String requestPage = request.getRequestURL().toString();
		String loginPage = "../login";
		System.out.println("client's request page : "+requestPage);
		
		boolean isLogin = false;
		if(request.getSession().getAttribute("userId")!=null){
			isLogin=true;
		}
		
		if (session == null || !isLogin) {
			System.out.println("has no session for this id");
			request.setAttribute("requestPage", requestPage);
//			response.sendRedirect(loginPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
		     dispatcher.forward(request, response);

			return false;
		}
		return true;
	}

}
