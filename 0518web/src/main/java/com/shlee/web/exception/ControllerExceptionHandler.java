package com.shlee.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//패키지를 이용해 컨트롤러 예외처리의 대상 컨트롤러 지정
//ControllerAdvice : 공통예외처리
// <component-scan> 필요함
@ControllerAdvice("com.shlee.web.controller")
public class ControllerExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerExceptionHanler(){
		return "null_eroor_page";
	}
	
}
