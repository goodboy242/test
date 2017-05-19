package com.shlee.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shlee.dao.IBoardDAO;
import com.shlee.domain.board.BoardVO;
import com.shlee.service.IBoardService;

@Service
public class BoardServiceImpl implements IBoardService{

	@Autowired
	private IBoardDAO boardDAO;
	
	@Override
	public int boardWrite(HashMap<String, String> hashMap) throws SQLException {
		return boardDAO.boardWrite(hashMap);
	}

	@Override
	public List<BoardVO> boardList() throws SQLException {
		return boardDAO.boardList();
	}

	@Override
	public BoardVO boardContents(String bidx) throws SQLException {
		boardDAO.updateHitcount(bidx);
		return boardDAO.boardContents(bidx);
	}

	@Override
	public int boardDelete(String bidx) throws SQLException {
		return boardDAO.boardDelete(bidx);
	}

	@Override
	public int boardModify(HashMap<String, String> hashMap) throws SQLException {
		return boardDAO.boardModify(hashMap);
	}

}
