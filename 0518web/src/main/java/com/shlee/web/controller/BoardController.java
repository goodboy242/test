package com.shlee.web.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shlee.web.domain.board.BoardVO;
import com.shlee.web.exception.NoArticleException;
import com.shlee.web.service.IBoardService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private String boardFolder= "board/";
	
	@Autowired
	private IBoardService boardService;

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
//	@ResponseBody
	public String boardList(Model model) throws SQLException {
		System.out.println("List request******");
		List<BoardVO> list = boardService.boardList();
		model.addAttribute("boardList", list);
//		return  boardFolder+"boardListXX";
		return "main2";
	}

	@RequestMapping(value = "/board/article/{bidx}", method = RequestMethod.GET)
//	@ResponseBody
	public String boardContents(@PathVariable String bidx, Model model) throws SQLException, NoArticleException {
		System.out.println("Article request******");
		BoardVO boardVO = boardService.boardContents(bidx);
		System.out.println(boardVO);
//		if(boardVO == null){
//			logger.info("NoArticleException 발생");
//			throw new NoArticleException(bidx);
//		}
		model.addAttribute("boardVO", boardVO);
		return  boardFolder+"board_article2";
	}

	@ExceptionHandler(NoArticleException.class)
	public String noArticleException(Model model, NoArticleException e) {
		model.addAttribute("ex_msg", e.getMessage());
		model.addAttribute("ex_info",e.exceptionInfo());
		return "/exception/error_handler";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String writePage() {
		logger.info("****************writing request****************");
		System.out.println("write request******");
		return boardFolder+"write_form";
	}
	
	@RequestMapping(value = "/board/write_complete", method = RequestMethod.POST)
	public String boardWrite(@RequestParam HashMap<String, String> hashMap, HttpServletRequest request) throws SQLException {
		hashMap.put("userId", request.getSession().getAttribute("userId").toString()); 
		boardService.boardWrite(hashMap);
		String url = "redirect:/board/list";

		return url;
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String boardDelete(@ModelAttribute("bidx") String bidx) throws SQLException {
		System.out.println("Delete request******");
		boardService.boardDelete(bidx);
		
		String url = "redirect:/board/list";

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
		String url = "redirect:/board/list";

		return url;
	}

}
