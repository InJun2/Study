package com.kh.app09.member.Controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app09.member.model.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private SqlSession sqlss;

	@GetMapping("insert")
	public String insert() {
		return "member/insert";
	}
	
	@PostMapping("insert")
	public String insert2(MemberVo vo) {
		sqlss.update("member.memberInsert", vo);	// member-mapper.xml������ "(namespace��).(�����sql id��)"�� ��ü�� ������ �������
		
		return "redirect:/member/insert";
	}
}
