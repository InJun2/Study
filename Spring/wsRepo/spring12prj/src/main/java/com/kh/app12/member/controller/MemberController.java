package com.kh.app12.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app12.member.entity.MemberVo;
import com.kh.app12.member.entity.SearchVo;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private SqlSession sqlSession; 
	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(MemberVo memberVo, Model model) {
		sqlSession.insert("member.joinMember", memberVo);
		model.addAttribute(memberVo);
		
		return "member/join_result";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVo membervo, HttpSession session) {	// HttpSession을 매개변수에 넣으면 spring이 자동으로 가져옴
		MemberVo loginUser = sqlSession.selectOne("member.selectMemberLogin", membervo);
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}
			return "common/errorPage";
	}
	
	@GetMapping("search")
	public String search(Model model) {
		List<MemberVo> memberList = sqlSession.selectList("member.selectMemberSearch");
		model.addAttribute("list",memberList);
		return "member/search";
	}
	
	@PostMapping("search")
	public String search(SearchVo svo, Model model) {
		List<MemberVo> memberList = sqlSession.selectList("member.selectMemberSearch", svo);
		model.addAttribute("list",memberList);
		
		return "member/search";
	}
	
	
}
