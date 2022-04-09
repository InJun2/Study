package com.example.demo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public List<BoardDto> list() throws Exception {
		List<BoardDto> boardDtoList = service.selectBoardList();
		
		return boardDtoList;
	}
	
	
	@PostMapping("/insert")
	public int insertBoard(@RequestParam String boardTitle, @RequestParam String boardContent, @RequestParam String user) throws Exception {	// post 처리는 어케해
		BoardDto boardDto = new BoardDto(boardTitle, boardContent, user);		// 해당부분 제거 및 파라미터를 @RequestBody BoardDto 로 받아올 예정
		int result = service.insertBoard(boardDto);
		
		return result;
	}
	
	@GetMapping("/detail/{boardNo}")
	public BoardDto detailBoard(@PathVariable String boardNo) throws Exception {
		BoardDto boardDto = service.selectBoardDetail(boardNo);
		
		return boardDto;
	}
	
	
	@PostMapping("/update")
	public int updateBoardPost(@RequestBody BoardDto dto) throws Exception {	// json library를 추가하지 않아서 json 데이터가 @ReqeustBody로 넘어왔지만 객체에 저장해주지 못했었음.. ( 오류 해결 )
		int result = service.updateBoard(dto);
		 
		return result;
	}
	
	@DeleteMapping("/delete/{deleteNo}")
	public int deleteBoard(@PathVariable String deleteNo) throws Exception{
		int result = service.deleteBoard(deleteNo);
		
		return result;
	}
	
	@PostMapping("/delete/admin")
	public int deleteUdminBoard(String deleteNoArr) throws Exception {
		int result = service.deleteUdminBoard(deleteNoArr);
		
		return result;
	}
}
