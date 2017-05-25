package com.shlee.web.dao.web.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shlee.web.dao.IBoardDAO;
import com.shlee.web.domain.board.BoardVO;

//UserDAOImple 클래스가 DAO의 역할을 수행한다는 것을 스프링에게 알려준다.
//Spring은 annotation driven을 통해 해당 클래스를 DAO로 인식
@Repository
public class BoardDAOImpl implements IBoardDAO {

	private static final String Namespace = "com.shlee.web.mapper.boardMapper";

	@Autowired
	SqlSession SqlSession;

	@Override
	public int boardWrite(HashMap<String, String> hashMap) throws SQLException {
		
		return SqlSession.insert(Namespace+".boardWrite", hashMap);		
	}

	@Override
	public List<BoardVO> boardList() throws SQLException {

		return SqlSession.selectList(Namespace+".boardList");		
	}

	@Override
	public BoardVO boardContents(String bidx) throws SQLException {

		return SqlSession.selectOne(Namespace+".boardContents", bidx);		
	}

	@Override
	public int boardDelete(String bidx) throws SQLException {
		
		return SqlSession.delete(Namespace+".boardDelete", bidx);		
	}

	@Override
	public void updateHitcount(String bidx) throws SQLException {
		
		SqlSession.delete(Namespace+".updateHitcount", bidx);	
	}

	@Override
	public int boardModify(HashMap<String, String> hashMap) throws SQLException {

		return SqlSession.update(Namespace+".boardModify", hashMap);		
	}
	
	@Override
	public int countArticle() throws SQLException{
		
		return SqlSession.selectOne(Namespace+".boardCount");		
	}


}
