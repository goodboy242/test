package com.shlee.web.service.web.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shlee.web.dao.IUserDAO;
import com.shlee.web.domain.LoginVO;
import com.shlee.web.domain.UserVO;
import com.shlee.web.service.IUserService;

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

	@Override
	public int checkDuplication(HashMap<String, String> hashMap) {
		return userDAO.checkDuplication(hashMap);
	}


}
