package com.shlee.web;

import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shlee.web.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/webapp/WEB-INF/spring/root-context.xml"))

public class UserServiceTest {

	@Autowired
	private IUserService userService;

	@Test
	public void testLoginUser() throws SQLException {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("userId", "lsh");
		hashMap.put("userPw", "lsh");
		
		System.out.println(userService.loginUser(hashMap));
	}
}
