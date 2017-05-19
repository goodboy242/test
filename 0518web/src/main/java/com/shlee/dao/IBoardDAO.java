package com.shlee.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.shlee.domain.board.BoardVO;

public interface IBoardDAO {

	public int boardWrite(HashMap<String, String> hashMap) throws SQLException ;
	public List<BoardVO> boardList() throws SQLException;
	public BoardVO boardContents(String bidx) throws SQLException;
	public int boardDelete(String bidx) throws SQLException ;
	public void updateHitcount(String bidx) throws SQLException ;
	public int boardModify(HashMap<String, String> hashMap) throws SQLException ;
	
}
