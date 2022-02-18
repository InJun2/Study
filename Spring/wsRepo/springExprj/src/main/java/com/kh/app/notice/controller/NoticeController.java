package com.kh.app.notice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.common.PageVo;
import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("notice")
@Slf4j
public class NoticeController {
	
	@Autowired
	private NoticeService service;

	@GetMapping(value = {"/list/{page}", "/list"})	// 중괄호안에 들어오는 요청들을 넣으면 그중 하나가 들어왔을 때 처리 가능
	public String list(Model model, @PathVariable(required = false)String page) throws Exception {
		if(page == null)
			page = "1";
		
		// 페이징 객체 필요
		int cntPerPage = 10;	// 한 페이지당 10개씩 보여주기
		int pageBtnCnt = 5;		// 한번에 보여줄 페이지 버튼 갯수
		int totalRow = service.getNoticeCnt();	// DB에 있는 모든 row 개수
		PageVo vo = new PageVo(page, cntPerPage, pageBtnCnt, totalRow);
		
		// 리스트 조회
		List<NoticeVo> list = service.getNoticeList(vo);
		model.addAttribute("list",list);
		model.addAttribute("page", vo);
		
		return "notice/list";
	}
	
	// 공지사항 작성하기 화면보여주기
	@GetMapping("write")
	public String write() {
		return "notice/write";
	}
	
	// 공지사항 작성 로직 처리
	@PostMapping("write")
	public String write(NoticeVo vo, HttpSession session) throws Exception {
		int result = service.write(vo);
		
		if(result >0) {
			return "redirect:/notice/list";
		}else {
			session.setAttribute("msg", "공지사항 작성 실패");
			return "error/errorPage";
		}	
	}
	
	@PostMapping("delete")
	@ResponseBody
	public String delete(String str) throws Exception {
		int result = service.deleteNotice(str);
		
		if(result == str.length()/2) {
			return "all success";
		}else {
			return "fail(success:" + result + ")";
		}
	}
	
}
