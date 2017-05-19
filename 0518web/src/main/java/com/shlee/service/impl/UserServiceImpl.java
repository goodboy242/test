package com.shlee.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shlee.dao.IUserDAO;
import com.shlee.domain.LoginVO;
import com.shlee.domain.UserVO;
import com.shlee.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public String getTime() {
		return null;
	}
	
	@Override
	public int joinUser(UserVO userVO) {
		return userDAO.joinUser(userVO);
	}

	@Override
	public LoginVO loginUser(HashMap<String, String> hashMap) {
		return userDAO.loginUser(hashMap);
	}


}
