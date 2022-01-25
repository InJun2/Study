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
		
		String pwd2 = sql.selectOne("member.selectLogin", id);
		
		boolean login = pe.matches(pwd,pwd2);	// pwd는 jsp로 받아온 pwd, pwd2는 db에서 가져온 암호화되어있는 pwd
		System.out.println(login);
		if(login == true) {
			return "redirect:/";			
		}else {
			return "redirect:/member/login";
		}
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
