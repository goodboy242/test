package com.shlee.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shlee.dao.IBoardDAO;
import com.shlee.domain.board.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/webapp/WEB-INF/spring/root-context.xml"))

public class BoardDAOTest {

	@Autowired
	private IBoardDAO boardDAO;

//	@Test
//	public void testBoardWrite() throws SQLException {
//		HashMap<String, String> hashMap = new HashMap<>();
//		hashMap.put("title", "this 777777 title");
//		hashMap.put("contents", "thisefefef is c7777777ontents");
//		hashMap.put("userId", "lsh");
//		
//		int result = boardDAO.boardWrite(hashMap);
////		System.out.println(result);
//	}
//
//	@Test
//	public void testBoardList() throws SQLException {
//		List<BoardVO> result = boardDAO.boardList();
//		Iterator it = result.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
//	
//	}
//	
//	@Test
//	public void testBoardContents() throws SQLException {
//		
//		System.out.println(boardDAO.boardContents("43"));
//	}
//
//	@Test
//	public void testboardDelete() throws SQLException {
//		
////		System.out.println(boardDAO.boardDelete("45"));
//	}
//	
//	@Test
//	public void testUpdateHitcount() throws SQLException {
//		
//		boardDAO.updateHitcount("50");
//	}
	
	@Test
	public void testboardModify() throws SQLException {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("title", "this is new title");
		hashMap.put("contents", "thisis new contents");
		hashMap.put("bidx", "83");
		hashMap.put("userId", "lsh");
		System.out.println(boardDAO.boardModify(hashMap));
	
	}
	
//	@Test
//	public void countArticle() throws SQLException{
//		System.out.println(boardDAO.countArticle());
//	}
//	
}
