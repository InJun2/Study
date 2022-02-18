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

	@GetMapping(value = {"/list/{page}", "/list"})	// �߰�ȣ�ȿ� ������ ��û���� ������ ���� �ϳ��� ������ �� ó�� ����
	public String list(Model model, @PathVariable(required = false)String page) throws Exception {
		if(page == null)
			page = "1";
		
		// ����¡ ��ü �ʿ�
		int cntPerPage = 10;	// �� �������� 10���� �����ֱ�
		int pageBtnCnt = 5;		// �ѹ��� ������ ������ ��ư ����
		int totalRow = service.getNoticeCnt();	// DB�� �ִ� ��� row ����
		PageVo vo = new PageVo(page, cntPerPage, pageBtnCnt, totalRow);
		
		// ����Ʈ ��ȸ
		List<NoticeVo> list = service.getNoticeList(vo);
		model.addAttribute("list",list);
		model.addAttribute("page", vo);
		
		return "notice/list";
	}
	
	// �������� �ۼ��ϱ� ȭ�麸���ֱ�
	@GetMapping("write")
	public String write() {
		return "notice/write";
	}
	
	// �������� �ۼ� ���� ó��
	@PostMapping("write")
	public String write(NoticeVo vo, HttpSession session) throws Exception {
		int result = service.write(vo);
		
		if(result >0) {
			return "redirect:/notice/list";
		}else {
			session.setAttribute("msg", "�������� �ۼ� ����");
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
