package com.kh.app22;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/cookie")
@Slf4j
public class CookieController {
	
	// 쿠키 만들기 
	@GetMapping("/create")
	@ResponseBody
	public String create(HttpServletResponse response) {
		// 쿠키 생성
		Cookie c = new Cookie("k01", "v01");
		
		c.setMaxAge(60 * 60 * 24);	// 지속시간 24시간으로 지정
		// 경로 지정 ( 이 해당 경로에서 쿠키 사용이 가능하게 함 )
		c.setPath("/");
		
		// 쿠키 전달
		response.addCookie(c);
		
		return "cookie create ";
	}
	
	// 쿠키 삭제
	@GetMapping("/delete")
	@ResponseBody
	public String delete(HttpServletResponse response) {
		Cookie c = new Cookie("k01", "v01");
		// 경로 지정 ( 이 해당 경로의 쿠키 유지시간 변경을 위해 지정 )
		
		c.setPath("/");
		// cookie 삭제는 존재하지 않으므로 쿠키 유지 시간을 0초로 지정해 바로 없어지게끔 함
		c.setMaxAge(0);
		
		// 쿠키전달
		response.addCookie(c);
		
		return "cookie delete";
	}
	
	// 쿠키 확인
	@GetMapping("/check")
	public String check(HttpServletResponse response) {
		return "cookie/check";
	}
	
	@GetMapping("/checkCtrl")
	@ResponseBody
	public String checkCtrl(@CookieValue(required = false) Cookie c) {	// CookieValue 어노테이션을 이용해서 Cookie값을 받아옴
		if(c != null) {
			log.info(c.getValue());
		}
		
		return "cookie check at controller";
	}

}
