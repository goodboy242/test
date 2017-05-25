package com.shlee.web.service;

import java.util.HashMap;

import com.shlee.web.domain.LoginVO;
import com.shlee.web.domain.UserVO;

public interface IUserService {

	public int joinUser(UserVO userVO);
	public String getTime();
	public LoginVO loginUser(HashMap<String, String> hashMap);
	public int checkDuplication(HashMap<String, String> hashMap);
}
