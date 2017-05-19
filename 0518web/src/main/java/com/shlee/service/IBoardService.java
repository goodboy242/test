package com.shlee.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.shlee.domain.board.BoardVO;

public interface IBoardService {

	public int boardWrite(HashMap<String, String> hashMap) throws SQLException ;
	public List<BoardVO> boardList() throws SQLException;
	public BoardVO boardContents(String bidx) throws SQLException;
	public int boardDelete(String bidx) throws SQLException ;
	public int boardModify(HashMap<String, String> hashMap) throws SQLException ;
	
}
