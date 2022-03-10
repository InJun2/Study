package com.example.neighbor.test.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.neighbor.dept.dto.DeptDto;
import com.example.neighbor.test.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Controller							// Controller 선언 
@RequestMapping("test")				// 요청 URI 매핑 선언
@MapperScan(value = {"com.example.neighbor.mapper"})	// @Mapper 클래스 지정
@Slf4j
public class TestController {
	
	@Autowired
	private TestService service;
	
	@GetMapping("resp")
	public @ResponseBody List<DeptDto> myName(){		// @ResponseBody : 결과를 view page가 아닌 데이터만 출력
		String date = service.getTime();
		List<DeptDto> dto = service.getUser();
		return dto;
	}
	
	@GetMapping("view")
	public String myUser(Model model) {					// Model에 정보를 저장후 apllication.properties에서 지정한 view resolver가 해당 view로 전달
		List<DeptDto> dto = service.getUser();
		model.addAttribute("dto", dto);
		log.trace("trace Massage");						// logback 에 해당 패키지내의 로그 정보는 debug 이상만 출력되므로 trace 로그는 출력되지 않음
		log.debug("debug Message");
		return "myUser";
	}
	
	
}
