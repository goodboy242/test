package com.shlee.web.dao;

import java.util.HashMap;

import com.shlee.web.domain.LoginVO;
import com.shlee.web.domain.UserVO;

public interface IUserDAO {

	public int joinUser(UserVO userVO);
	public String getTime();
	public LoginVO loginUser(HashMap<String, String> hashMap);
	public int checkDuplication(HashMap<String, String> hashMap);
}
