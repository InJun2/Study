package com.example.demo.board.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.service.BoardService;
import com.example.demo.security.authentication.AuthenticationMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private AuthenticationMethod auth;	
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		List<BoardDto> boardDto = service.selectBoardList();
		model.addAttribute("list", boardDto);
		model.addAttribute("user", auth.getUserId());
		
		if(auth.getAuthentication())
			return "board/adminBoardList";
		
		return "board/BoardList";
	}
	
	@GetMapping("/insert")
	public String insertBoard() {
		return "board/insertBoard";
	}
	
	@PostMapping("/insert")
	public String insertBoard(@RequestParam String boardTitle, @RequestParam String boardContent, Model model) throws Exception {
		BoardDto boardDto = new BoardDto(boardTitle, boardContent, auth.getUserId());
		service.insertBoard(boardDto);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/detail/{boardNo}")
	public String detailBoard(@PathVariable String boardNo, Model model) throws Exception {
		BoardDto boardDto = service.selectBoardDetail(boardNo);
		boolean userCheck = service.userCheck(boardDto);
		model.addAttribute("userCheck", userCheck);
		model.addAttribute("boardDto", boardDto);
		
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
	@ResponseBody
	public List<BoardDto> deleteUdminBoard(String deleteNoArr) throws Exception {
		service.deleteUdminBoard(deleteNoArr);
		List<BoardDto> list = service.selectBoardList();
		
		return list;
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String test() throws Exception {
		String result = service.testResult();
		
		return result;
	}
	
	@PostMapping("/test/update")
	@ResponseBody
	public int updateTest(BoardDto dto) throws IOException {
		int result = service.updateTest(dto);
		
		return result;
	}
	
}
