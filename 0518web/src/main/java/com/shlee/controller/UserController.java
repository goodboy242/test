package com.shlee.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shlee.domain.LoginVO;
import com.shlee.service.IUserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private String userFolder = "login/";

	@Autowired
	private IUserService service;

	@RequestMapping("login")
	public String login() {
		logger.info("****************Login****************");
		return userFolder + "login_form";
	}

	@RequestMapping(value = "/loginchk", method = RequestMethod.POST)
	public String loginCheck(@RequestParam HashMap<String, String> hashMap, Model model) {
		LoginVO loginVO = service.loginUser(hashMap);
		System.out.println(loginVO);
		if (loginVO != null) {
			model.addAttribute("userData", loginVO);
			model.addAttribute("requestPage",hashMap.get("requestPage"));
		}
		return userFolder + "login_fail";
		// return "main";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession session, Model model) {
		System.out.println("loggout");
		session.invalidate();
		if (model.containsAttribute("userId")) {
			model.asMap().remove("userId");
			System.out.println("userId removed");
		}
		String url = "redirect:/";

		return url;
	}

}
