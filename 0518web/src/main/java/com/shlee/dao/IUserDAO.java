package com.shlee.dao;

import java.util.HashMap;

import com.shlee.domain.LoginVO;
import com.shlee.domain.UserVO;

public interface IUserDAO {

	public int joinUser(UserVO userVO);
	public String getTime();
	public LoginVO loginUser(HashMap<String, String> hashMap);

}
