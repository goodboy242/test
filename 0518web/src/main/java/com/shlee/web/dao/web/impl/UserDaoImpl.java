package com.shlee.web.dao.web.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shlee.web.dao.IUserDAO;
import com.shlee.web.domain.LoginVO;
import com.shlee.web.domain.UserVO;

//UserDAOImple 클래스가 DAO의 역할을 수행한다는 것을 스프링에게 알려준다.
//Spring은 annotation driven을 통해 해당 클래스를 DAO로 인식
@Repository
public class UserDaoImpl implements IUserDAO{

	private static final String Namespace="com.shlee.web.mapper.userMapper";
	
	@Autowired
	SqlSession SqlSession; 
	
	@Override
	public String getTime() {
		//namespace와 query의 id를 조합하여 쿼리 실행
		return SqlSession.selectOne(Namespace+".getTime");
	}
	
	@Override
	public int joinUser(UserVO userVO) {
		return SqlSession.insert(Namespace+".insertUser", userVO);
	}

	@Override
	public LoginVO loginUser(HashMap<String, String> hashMap) {
		return SqlSession.selectOne(Namespace+".loginUser", hashMap);
	}

	@Override
	public int checkDuplication(HashMap<String, String> hashMap) {
		return SqlSession.selectOne(Namespace+".checkDuplication", hashMap);
	}

}
