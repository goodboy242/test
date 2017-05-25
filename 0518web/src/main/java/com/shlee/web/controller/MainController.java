package com.shlee.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/")
	public String mainPage() {
		logger.info("****************Main****************");
		System.out.println("Main***");
		return "main";
	}

	// exception handling test
	@RequestMapping("/error")
	public String doError() {
		int result = 10 / 0;
		return "error";
	}

	// 현재 예제는 MainController에서만 예외를 처리
	// 현재 컨트롤러에서 발생하는 산술연산 오류에 대해 처리 하겠다.
	// @ExceptionHandler (Exception.class)=> 발생되는 모든 오류예외처리
	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticException(Model model, Exception e) {
		model.addAttribute("ex_msg", e.getMessage());

		return "error_handler";
	}

}
