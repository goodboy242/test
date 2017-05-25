package com.shlee.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyFirstAop {

	Logger logger = LoggerFactory.getLogger(MyFirstAop.class);

	// execution( [접근지시제어자] [리턴형태] [클래스의 상세 위치] [메소드 이름(파라미터)] )
	@Around("within(com.shlee.web.service..*)")
	public Object userLogger(ProceedingJoinPoint joinPoint) throws Throwable {
		String signature = joinPoint.getSignature().toString();
		logger.info(signature + "start");

		try {
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			logger.info(signature + "end");
		}
	}
}
