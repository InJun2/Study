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

	// �Խñ� �ۼ� ������ �����ֱ�
	@GetMapping("insert")
	public String insert() {
		return "board/insert";
	}
	
	// �Խñ� �ۼ� ���� ó��
	@PostMapping("insert")
	public String insert(@ModelAttribute BoardDto dto) {
		// ���� ó�� -> �������� �ñ�
		int result=0;
		try {
			result = service.enrollBoard(dto);
			// ȭ�� ����
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
	// �Խñ� ��� ��ȸ
	@GetMapping("list")
	public ModelAndView list(ModelAndView mv) {
		// db���� �������� ȭ������ ����
		List<BoardDto> list = service.selectBoard(); 
		// model
		mv.addObject("list",list);
		// view
		mv.setViewName("board/list");
		// view ����
		return mv;
	}
	
	// �� ������ ��ȸ
	@GetMapping("detail/{t}")	// jsp���� Ư������ ���� ( �̸��� ���������� t�� ���� )
	public String detail(@PathVariable String t, Model model) {		// @PathVariable �� GetMapping���� {}�� ���� �̸��� ���� ������ �� ���, 
																	// detail?title=t�� �ƴ� detail/t�� ��ũ�� ���� ����
		BoardDto dto = service.selectBoardDetail(t);
		model.addAttribute("dto", dto);
		
		return "board/detail";
	}
	// �������� ����
	@PostMapping("edit")
	public String edit(BoardDto dto) {
		int result = service.edit(dto);
		
		if(result>0) {
			return "redirect:/board/list";
		}else {
			return "common/error/fail";
		}
	}
	// ��������� ����
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
