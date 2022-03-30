package com.example.demo.member.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.member.service.MemberService;
import com.example.demo.member.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping({"/login", "/"})
	public String login() {
		return "member/login";
	}
	
	@GetMapping("/join")
	public String join() {
			return "member/join";
	}
	

	@PostMapping("/join")
	public String join(MemberVo vo, Model model) {
		if(service.checkId(vo.getUserId()) != null) {
			model.addAttribute("msg", "동일한아이디가 존재합니다");
			return "common/error";
		}
		
		if(service.joinUser(vo) > 0)
			return "redirect:/login";
		
		model.addAttribute("msg", "회원가입에 실패하였습니다");
		return "common/error";
	}

	@GetMapping("/A")
	public String A() {
		return "A";
	}
	
	@GetMapping("/B")
	public String B() {
		return "B";
	}
	
	@GetMapping("/C")
	public String C() {
		return "C";
	}
	
	
}
