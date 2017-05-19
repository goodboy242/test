package com.shlee.service;

import java.util.HashMap;

import com.shlee.domain.LoginVO;
import com.shlee.domain.UserVO;

public interface IUserService {

	public int joinUser(UserVO userVO);
	public String getTime();
	public LoginVO loginUser(HashMap<String, String> hashMap);
	
}
