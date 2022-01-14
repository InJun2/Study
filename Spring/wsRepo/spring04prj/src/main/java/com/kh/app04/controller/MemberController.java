package com.kh.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.app04.member.model.vo.MemberVo;

@Controller
@RequestMapping("/member")	// ���� �մܰ迡 member �߰� ex) url : app04/member/join 
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
	public String join2(
			@RequestParam(name="id") String memberId, 	// jsp���� �޾ƿ� �� name�� �µ��� �����̸��� �����ϸ� �׳� ������!
			@RequestParam String pwd, 
			@RequestParam(defaultValue="default") String name,
			@RequestParam int age) {
		System.out.println("join post��û ó����");
//		String id = req.getParameter("id");	// jsp������ ������ ���, public String join2(HttpServletRequest req)ó�� �Ű����� �߰��ؾ���
		System.out.println("id : " + memberId);
		System.out.println("pwd : " + pwd);
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		return "member/join_result";
	}
	
	@PostMapping("/join2")
	public String join3(
			@ModelAttribute MemberVo vo) {	// MemberVo ��ü����� @ModelAtrribute ������̼� �߰�(���͵��� ��������� �ִ°��� ���� )
											// �ش� ��ü�� �˾Ƽ� �������ְ� ���� �ٷΰ�����, modelVo�� �޼ҵ� set(name)�� ȭ���� name�� ���ƾ� ��
		System.out.println("join post��û ó����");
		
		System.out.println("id : " + vo.getId());
		System.out.println("pwd : " + vo.getPwd());
		System.out.println("name : " + vo.getName());
		System.out.println("age : " + vo.getAge());
		
		return "member/join_result";
	}
	
}
