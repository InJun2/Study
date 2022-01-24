package com.kh.app14.member.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app14.member.entity.MemberDto;
import com.kh.app14.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;	// 해당 클래스를 사용하는데 new 생성자로 생성하면 해당 클래스는 spring-container에 등록되지 않음
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private PasswordEncoder pe;			// spring-security
	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(MemberDto dto) {
		int result = memberservice.join(dto);		//service레이어로 맡김

		if(result > 0) {
			return "redirect:/";
		}else {
			return "redirect:/member/join";
		}
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberDto dto, HttpSession session) {
		MemberDto member = ss.selectOne("member.login", dto);
		if(member == null) {
			return "redirect:/member/login";
		}
		
		String userPwd = dto.getPwd();
		
		if(pe.matches(userPwd, member.getPwd())) {
			session.setAttribute("loginMember", member);
			return "redirect:/";
		}else {
			
			return "redirect:/member/login";
		}		
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
