package com.kh.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.entity.MemberDto;
import com.kh.app.member.service.MemberService;


@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	//�α��� ȭ�� �����ֱ�
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	// �α��� ���� ó��
	@PostMapping("login")
	public String login(MemberDto dto, HttpSession session) throws Exception {
		MemberDto loginUser = service.login(dto);
		
		// loginUser ���� 
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}else {
			return "redirect:/";
		}
	}
	
	// ȸ������ ȭ�� �����ֱ�
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	// ȸ������ ���� ó��
	@PostMapping("join")
	public String join(MemberDto dto, HttpServletRequest req) throws Exception {
		 int result = service.join(dto, req);
		
		 if(result>0) {
			 return "redirect:/member/login";
		 }else {
			 return "redirect:/member/join";
		 }
	}
	
	// �α׾ƿ�
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// ���������� ȭ�� �����ֱ�
	@GetMapping("mypage")
	public String mypage(HttpSession session) {
		// �α����� ��쿡�� �����ֱ�
		MemberDto loginUser = (MemberDto)session.getAttribute("loginUser");
		if(loginUser == null) {
			session.setAttribute("msg","�α��� ���� ����");
			return "error/errorPage";
		}
		
		return "member/mypage";
	}
	
	// ���������� �� ���� ���� ���� ó��
	@PostMapping("mypage")
	public String mypage(MemberDto dto, HttpSession session) throws Exception {
		// ������Ʈ ó��
		MemberDto member = service.editMember(dto);
		
		if(member != null) {
			session.setAttribute("loginUser", member);
			return "redirect:/";
		}else {
			return "redirect:/member/errorpage";
		}
	}
	
}
