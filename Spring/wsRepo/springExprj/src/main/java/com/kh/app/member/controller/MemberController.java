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
	
	//로그인 화면 보여주기
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	// 로그인 로직 처리
	@PostMapping("login")
	public String login(MemberDto dto, HttpSession session) throws Exception {
		MemberDto loginUser = service.login(dto);
		
		// loginUser 정보 
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}else {
			return "redirect:/";
		}
	}
	
	// 회원가입 화면 보여주기
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	// 회원가입 로직 처리
	@PostMapping("join")
	public String join(MemberDto dto, HttpServletRequest req) throws Exception {
		 int result = service.join(dto, req);
		
		 if(result>0) {
			 return "redirect:/member/login";
		 }else {
			 return "redirect:/member/join";
		 }
	}
	
	// 로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 마이페이지 화면 보여주기
	@GetMapping("mypage")
	public String mypage(HttpSession session) {
		// 로그인한 경우에만 보여주기
		MemberDto loginUser = (MemberDto)session.getAttribute("loginUser");
		if(loginUser == null) {
			session.setAttribute("msg","로그인 정보 없음");
			return "error/errorPage";
		}
		
		return "member/mypage";
	}
	
	// 마이페이지 내 정보 수정 로직 처리
	@PostMapping("mypage")
	public String mypage(MemberDto dto, HttpSession session) throws Exception {
		// 업데이트 처리
		MemberDto member = service.editMember(dto);
		
		if(member != null) {
			session.setAttribute("loginUser", member);
			return "redirect:/";
		}else {
			return "redirect:/member/errorpage";
		}
	}
	
}
