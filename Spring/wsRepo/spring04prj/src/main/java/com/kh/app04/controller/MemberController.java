package com.kh.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mem")	// ���� �մܰ迡 mem �߰� ex) url : app04/mem/join 
public class MemberController {
	//	1. �޼ҵ� ���������ڴ� ������ public
	//	2. return ���� �ּ� ������ �־����
	//	3. �Ű������� �־�ǰ�, �����
	//	4. �޼ҵ� �̸��� ����
	
//	@RequestMapping(value = "/join", method = RequestMethod.GET )
	@GetMapping("/join")
	public String join() {
		System.out.println("join get ��û ó����");
		return "member/join"; // servlet-context.xml���� beans class���Ͽ��� �ش� ��� ���λ�� .jsp ���̻縦 �߰�����
	}
	
//	@RequestMapping(value = "/join", method = RequestMethod.POST )
	@PostMapping("/join")
	public String join2() {
		System.out.println("join post��û ó����");
		return "member/join_result";
	}
	
}
