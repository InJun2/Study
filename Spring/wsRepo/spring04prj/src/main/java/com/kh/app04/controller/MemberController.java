package com.kh.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mem")	// 매핑 앞단계에 mem 추가 ex) url : app04/mem/join 
public class MemberController {
	//	1. 메소드 접근제한자는 무조건 public
	//	2. return 값은 주소 가지고 있어야함
	//	3. 매개변수는 있어도되고, 없어도됨
	//	4. 메소드 이름은 자유
	
//	@RequestMapping(value = "/join", method = RequestMethod.GET )
	@GetMapping("/join")
	public String join() {
		System.out.println("join get 요청 처리함");
		return "member/join"; // servlet-context.xml에서 beans class파일에서 해당 경로 접두사와 .jsp 접미사를 추가해줌
	}
	
//	@RequestMapping(value = "/join", method = RequestMethod.POST )
	@PostMapping("/join")
	public String join2() {
		System.out.println("join post요청 처리함");
		return "member/join_result";
	}
	
}
