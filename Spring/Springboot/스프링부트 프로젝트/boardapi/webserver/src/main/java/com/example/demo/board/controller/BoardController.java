package com.example.demo.board.controller;

import java.util.List;

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
	
	private BoardService service;
	private AuthenticationMethod auth;	
	
	public BoardController(BoardService service, AuthenticationMethod auth) {
		this.service = service;
		this.auth = auth;
	}
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		List<BoardDto> boardList = service.loadBoardList();
		model.addAttribute("list", boardList);
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
		model.addAttribute("userCheck", auth.userCheck(boardDto.getBoardWriter()));
		model.addAttribute("boardDto", boardDto);
		
		return "board/detailBoard";
	}
	
	@GetMapping("/update/{boardNo}")
	public String updateBoard(@PathVariable String boardNo, Model model) throws Exception {
		BoardDto boardDto = service.selectBoardDetail(boardNo);
		if(!auth.userCheck(boardDto.getBoardWriter()))
			return "redirect:/board/list";
		model.addAttribute("boardDto", boardDto);
		
		return "board/updateBoard";
	}
	
	@PostMapping("/update")
	public String updateBoardPost(BoardDto dto) throws Exception {
		int result = service.updateBoard(dto);
		if(result > 0) {
			return "redirect:/board/list";
		}
		
		throw new Exception("게시판 업데이트 실패");
	}
	
	@GetMapping("/delete/{deleteNo}")
	public String deleteBoard(@PathVariable String deleteNo) throws Exception{
		int result = service.deleteBoard(deleteNo);
		if(result > 0) {
			return "redirect:/board/list";
		}
		
		throw new Exception("게시판 삭제 실패");
	}
	
	@GetMapping("/delete/admin/{deleteNoArr}")
	@ResponseBody
	public List<BoardDto> deleteUdminBoard(@PathVariable String deleteNoArr) throws Exception {
		service.deleteUdminBoard(deleteNoArr);
		List<BoardDto> list = service.loadBoardList();
		
		return list;
	}
	
}
