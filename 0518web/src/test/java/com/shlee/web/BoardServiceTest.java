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

import com.shlee.web.domain.board.BoardVO;
import com.shlee.web.exception.NoArticleException;
import com.shlee.web.service.IBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/webapp/WEB-INF/spring/root-context.xml"))

public class BoardServiceTest {

	@Autowired
	private IBoardService boardService;

	@Test
	public void testBoardWrite() throws SQLException {
		
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("title", "this is title");
		hashMap.put("contents", "thisefefef is contents");
		hashMap.put("userId", "lsh");
		
		int result = boardService.boardWrite(hashMap);
		System.out.println(result);
	}

	@Test
	public void testBoardList() throws SQLException {
		List<BoardVO> result = boardService.boardList();
		Iterator it = result.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	
	}
	
	@Test
	public void testBoardContents() throws SQLException, NoArticleException {
		
		System.out.println(boardService.boardContents("43"));
	}

	@Test
	public void testboardDelete() throws SQLException {
		
		System.out.println(boardService.boardDelete("53"));
	}
	
	
	@Test
	public void testboardModify() throws SQLException {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("title", "this is new title");
		hashMap.put("contents", "thisis new contents");
		hashMap.put("bidx", "52");
		
		System.out.println(boardService.boardModify(hashMap));
	
	}
	
	
	
}
