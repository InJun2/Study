package com.kh.app14.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.app14.board.entity.BoardDto;
import com.kh.app14.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;

	// 게시글 작성 페이지 보여주기
	@GetMapping("insert")
	public String insert() {
		return "board/insert";
	}
	
	// 게시글 작성 로직 처리
	@PostMapping("insert")
	public String insert(@ModelAttribute BoardDto dto) {
		// 로직 처리 -> 서비스한테 맡김
		int result=0;
		try {
			result = service.enrollBoard(dto);
			// 화면 선택
			if(result > 0 ) {
				return "redirect:/board/list";
			}else {			
				return "common/error/fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error/fail";
		}
	}
	// 게시글 목록 조회
	@GetMapping("list")
	public ModelAndView list(ModelAndView mv) {
		// db에서 가져오고 화면으로 전달
		List<BoardDto> list = service.selectBoard(); 
		// model
		mv.addObject("list",list);
		// view
		mv.setViewName("board/list");
		// view 선택
		return mv;
	}
	
	// 상세 페이지 조회
	@GetMapping("detail/{t}")	// jsp에서 특정값을 전달 ( 이름은 임의적으로 t로 선언 )
	public String detail(@PathVariable String t, Model model) {		// @PathVariable 은 GetMapping에서 {}의 값과 이름을 같게 설정한 후 사용, 
																	// detail?title=t가 아닌 detail/t의 링크로 실행 가능
		BoardDto dto = service.selectBoardDetail(t);
		model.addAttribute("dto", dto);
		
		return "board/detail";
	}
	// 상세페이지 수정
	@PostMapping("edit")
	public String edit(BoardDto dto) {
		int result = service.edit(dto);
		
		if(result>0) {
			return "redirect:/board/list";
		}else {
			return "common/error/fail";
		}
	}
	// 상세페이즈에서 삭제
	@PostMapping("delete")
	public String delete(BoardDto dto) {
		int result = service.delete(dto);
		
		if(result>0) {
			return "redirect:/board/list";
		}else {
			return "common/error/fail";
		}
	}
}
