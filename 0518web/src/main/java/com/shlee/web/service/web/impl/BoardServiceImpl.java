package com.shlee.web.service.web.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shlee.web.dao.IBoardDAO;
import com.shlee.web.domain.board.BoardVO;
import com.shlee.web.exception.NoArticleException;
import com.shlee.web.service.IBoardService;

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
	@Transactional(rollbackFor=NoArticleException.class)
	public BoardVO boardContents(String bidx) throws SQLException, NoArticleException {
		boardDAO.updateHitcount(bidx);
		BoardVO boardVO = boardDAO.boardContents(bidx);
		if(boardVO == null){
			throw new NoArticleException(bidx);
		}
		
		return boardVO;
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
