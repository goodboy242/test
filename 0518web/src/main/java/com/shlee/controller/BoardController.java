package com.shlee.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shlee.domain.board.BoardVO;
import com.shlee.service.IBoardService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private String boardFolder= "board/";
	
	@Autowired
	private IBoardService boardService;

	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String writePage() {
		logger.info("****************writing request****************");
		System.out.println("write request******");
		return boardFolder+"write_form";
	}

	@RequestMapping(value = "/board/write_complete", method = RequestMethod.POST)
	public String boardWrite(@RequestParam HashMap<String, String> hashMap, Model model) throws SQLException {
		hashMap.put("userid", "lsh"); // userID param !!!!!!
		boardService.boardWrite(hashMap);
		model.addAttribute("boardData", hashMap);
		return boardFolder+"board";
	}

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	@ResponseBody
	public List<BoardVO> boardList() throws SQLException {
		System.out.println("List request******");
		List<BoardVO> list = boardService.boardList();
		return list;
	}

	@RequestMapping(value = "/board/contents", method = RequestMethod.GET)
	@ResponseBody
	public BoardVO boardContents(@ModelAttribute("bidx") String bidx) throws SQLException {
		System.out.println("Contents request******");
		BoardVO boardVO = boardService.boardContents(bidx);
		return boardVO;
	}

	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String boardDelete(@ModelAttribute("bidx") String bidx) throws SQLException {
		System.out.println("Delete request******");
		boardService.boardDelete(bidx);
		
		String url = "redirect:/board/list/";

		return url;
	}
	
	@RequestMapping(value = "/board/edit", method = RequestMethod.GET)
	public String editPage() {
		System.out.println("edit request******");
		return boardFolder+"edit_form";
	}
	
	@RequestMapping(value = "/board/edit_complete", method = RequestMethod.POST)
	public String boardModify(@RequestParam HashMap<String, String> hashMap, Model model) throws SQLException {
		hashMap.put("userid", "lsh"); // userID param !!!!!!
		hashMap.put("bidx", "20"); // userID param !!!!!!
		boardService.boardModify(hashMap);
		model.addAttribute("boardData", hashMap);
		return boardFolder+"board";
	}

}
