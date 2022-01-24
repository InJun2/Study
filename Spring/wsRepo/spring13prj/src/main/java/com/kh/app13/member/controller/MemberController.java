package com.kh.app13.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app13.member.entity.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private SqlSession sql;
	
	@Autowired
	private PasswordEncoder pe;
	
	
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto m) {
		String newPwd = pe.encode(m.getPwd());
		m.setPwd(newPwd);
		
		sql.insert("member.join", m);
		return "redirect:/";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(String id, String pwd) {
		String newPwd = pe.encode(pwd);
		
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", newPwd);
		
		boolean login = pwd.matches("$2a$10$acirGK2eQZCgRll4dylKDefWecnFF9KFkRMYVA6I57ow/fo6bYEsK");
		System.out.println(login);
		MemberDto dto = sql.selectOne("member.login", map);
		
		return "redirect:/";
	}
	
	
	@GetMapping("list")
	public String list(Model model, String type, String value) {
		Map<String, Object> map = new HashMap<>();
		map.put("t", type);
		map.put("v", value);
		if("age".equals(type)) {
			map.put("v", value.split(","));
		} 
		
		List<MemberDto> memberList = sql.selectList("member.selectMember", map);
		
		model.addAttribute("memberList", memberList);
		
		return "member/list";
		
	}
	
	
}
