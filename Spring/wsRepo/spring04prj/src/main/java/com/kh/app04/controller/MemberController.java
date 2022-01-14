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
@RequestMapping("/member")	// 매핑 앞단계에 member 추가 ex) url : app04/member/join 
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
	public String join2(
			@RequestParam(name="id") String memberId, 	// jsp에서 받아온 값 name만 맞도록 변수이름을 설정하면 그냥 가져옴!
			@RequestParam String pwd, 
			@RequestParam(defaultValue="default") String name,
			@RequestParam int age) {
		System.out.println("join post요청 처리함");
//		String id = req.getParameter("id");	// jsp에서의 기존의 방식, public String join2(HttpServletRequest req)처럼 매개변수 추가해야함
		System.out.println("id : " + memberId);
		System.out.println("pwd : " + pwd);
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		return "member/join_result";
	}
	
	@PostMapping("/join2")
	public String join3(
			@ModelAttribute MemberVo vo) {	// MemberVo 객체만들고 @ModelAtrribute 어노테이션 추가(위와동일 없어도되지만 있는것이 좋음 )
											// 해당 객체를 알아서 생성해주고 값을 바로가져옴, modelVo의 메소드 set(name)과 화면의 name이 같아야 함
		System.out.println("join post요청 처리함");
		
		System.out.println("id : " + vo.getId());
		System.out.println("pwd : " + vo.getPwd());
		System.out.println("name : " + vo.getName());
		System.out.println("age : " + vo.getAge());
		
		return "member/join_result";
	}
	
}
