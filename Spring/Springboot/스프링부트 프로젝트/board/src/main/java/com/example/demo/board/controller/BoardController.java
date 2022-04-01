package com.example.demo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	private boolean getAuthentication() {	// Context안의 인증권한에 "ROLE_ADMIN"이 있다면 true
		boolean result = false;
		
		List<GrantedAuthority> list = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority gaut : list) {
			if(gaut.equals(new SimpleGrantedAuthority("ROLE_ADMIN"))) 
				result= true;
		}
		return result;
	}
	
	private String getUserId() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		List<BoardDto> boardDto = service.selectBoardList();
		model.addAttribute("list", boardDto);
		model.addAttribute("user", getUserId());
		
		if(getAuthentication())
			return "board/adminBoardList";
		
		return "board/BoardList";
	}
	
	@GetMapping("/insert")
	public String insertBoard() {
		return "board/insertBoard";
	}
	
	@PostMapping("/insert")
	public String insertBoard(@RequestParam String boardTitle, @RequestParam String boardContent) throws Exception {
		BoardDto boardDto = new BoardDto(boardTitle, boardContent, getUserId());
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
	public String deleteBoard(@PathVariable String deleteNo, Model model) throws Exception{
		System.out.println("자꾸 list들어감 : " + deleteNo);
		service.deleteBoard(deleteNo);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/delete/admin")
	public String deleteUdminBoard(String deleteNoArr) throws Exception {
		service.deleteUdminBoard(deleteNoArr);
		
		return "redirect:/board/list";
	}
	
}
