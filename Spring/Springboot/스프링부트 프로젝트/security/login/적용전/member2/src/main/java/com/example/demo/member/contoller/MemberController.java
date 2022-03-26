package com.example.demo.member.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.member.service.MemberService;
import com.example.demo.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("login")
	public String login(HttpSession session, Model model) {
		MemberVo user = (MemberVo) session.getAttribute("user");
		if(user == null)
			return "member/login";
		return getUserAuthority(user, model);
	}
	
	@GetMapping("join")
	public String join(HttpSession session, Model model) {
		MemberVo user = (MemberVo) session.getAttribute("user");
		if(user == null)
			return "member/join";
		return getUserAuthority(user, model);
	}
	
	@PostMapping("login")
	public String login(MemberVo vo, Model model, HttpSession session) {
		MemberVo user = service.loginUser(vo);
		if(user == null) {
			model.addAttribute("msg", "잘못된 로그인 정보입니다");
			return "common/error";
		}
		model.addAttribute("user", user);
		session.setAttribute("user", user);
		
		return getUserAuthority(user, model);
	}
	
	@PostMapping("join")
	public String join(MemberVo vo, Model model) {
		if(service.checkId(vo) != null) {
			model.addAttribute("msg", "동일한아이디가 존재합니다");
			return "common/error";
		}
		
		if(service.joinUser(vo) > 0)
			return "redirect:/member/login";
		
		model.addAttribute("msg", "회원가입에 실패하였습니다");
		return "common/error";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/login";
	}
	
	@GetMapping("A")
	public String a(HttpSession session, Model model) {
		MemberVo user = (MemberVo) session.getAttribute("user"); 
		if(user.getUserAuthority().equals("ROLE_A") || user.getUserAuthority().equals("ROLE_ADMIN"))
			return "A";
		return sessionError(model);
	}
	
	@GetMapping("B")
	public String b(HttpSession session, Model model) {
		MemberVo user = (MemberVo) session.getAttribute("user"); 
		if(user.getUserAuthority().equals("ROLE_B") || user.getUserAuthority().equals("ROLE_ADMIN"))
			return "B";
		return sessionError(model);
	}
	
	@GetMapping("home")
	public String home(HttpSession session, Model model) {
		MemberVo user = (MemberVo) session.getAttribute("user"); 
		if(user.getUserAuthority().equals("ROLE_ADMIN"))
			return "home";
		return sessionError(model);
	}
	
	private String getUserAuthority(MemberVo user, Model model) {
		if(user.getUserAuthority().equals("ROLE_A")) {
			return "A";
		}
		if(user.getUserAuthority().equals("ROLE_B")) {
			return "B";
		}
		if(user.getUserAuthority().equals("ROLE_ADMIN")) {
			return "home";
		}
		
		return sessionError(model);
	}
	
	private String sessionError(Model model) {
		model.addAttribute("msg", "접근권한이 없거나, 잘못된 세션 정보 입니다");
		return "common/error";
	}
	
}
