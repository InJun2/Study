package com.example.demo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public List<BoardDto> list() throws Exception {
		List<BoardDto> boardDtoList = service.selectBoardList();
		
		return boardDtoList;
	}
	
	
	@PostMapping("/insert")
	public List<BoardDto> insertBoard(@RequestParam String boardTitle, @RequestParam String boardContent, @RequestParam String user) throws Exception {	// post 처리는 어케해
		BoardDto boardDto = new BoardDto(boardTitle, boardContent, user);
		service.insertBoard(boardDto);
		List<BoardDto> boardDtoList = service.selectBoardList();
		
		return boardDtoList;
	}
	
	@GetMapping("/detail/{boardNo}")
	public String detailBoard(@PathVariable String boardNo) throws Exception {
		BoardDto boardDto = service.selectBoardDetail(boardNo);
		boolean userCheck = service.userCheck(boardDto);
		
		return "board/detailBoard";
	}
	
	@GetMapping("/update/{boardNo}")
	public String updateBoard(@PathVariable String boardNo, Model model) throws Exception {
		BoardDto boardDto = service.selectBoardDetail(boardNo);
		if(!service.userCheck(boardDto))
			return "redirect:/board/list";
		model.addAttribute("boardDto", boardDto);
		
		return "board/updateBoard";
	}
	
	@PostMapping("/update")
	public String updateBoardPost(BoardDto dto) throws Exception {
		service.updateBoard(dto);
		 
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete/{deleteNo}")
	public String deleteBoard(@PathVariable String deleteNo) throws Exception{
		service.deleteBoard(deleteNo);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/delete/admin")
	public List<BoardDto> deleteUdminBoard(String deleteNoArr) throws Exception {
		service.deleteUdminBoard(deleteNoArr);
		List<BoardDto> list = service.selectBoardList();
		
		return list;
	}
}
