package com.shlee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shlee.domain.LoginVO;

public class SetLoginSessionInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(SetLoginSessionInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle 에 오긴했어");

		LoginVO loginVO = (LoginVO) modelAndView.getModel().get("userData");
		if (loginVO != null) {// login 성공 시
			String userId = loginVO.getUserId();
			System.out.println(userId);
			String requestPage = modelAndView.getModel().get("requestPage").toString();
			System.out.println(requestPage);
			System.out.println("login sucess");
			request.getSession().setAttribute("userId", loginVO.getUserId());
			response.sendRedirect(requestPage);
		}

	}

}
