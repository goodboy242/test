package com.shlee.web;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shlee.dao.IUserDAO;
import com.shlee.domain.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/webapp/WEB-INF/spring/root-context.xml"))

public class UserDAOTest {

	@Autowired
	private IUserDAO userDao;

	@Test
	public void testGetTime() {
		System.out.println(userDao.getTime());
	}

	@Test
	public void testInsertUser() {
		UserVO userVO = new UserVO();
		userVO.setUserId("lsh");
		userVO.setUserPw("lsh");
		userVO.setUserName("lsh");
		userVO.setEmail("lsh");
		
		userDao.joinUser(userVO);
	}

	@Test
	public void testLoginUser(){
		HashMap<String,String> hashMap = new HashMap<>();
		hashMap.put("userId", "lsh");
		hashMap.put("userPw", "lsh");
		
		System.out.println(userDao.loginUser(hashMap));
	}
	
}
