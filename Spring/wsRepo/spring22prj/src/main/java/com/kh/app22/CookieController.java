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
	
	// ��Ű ����� 
	@GetMapping("/create")
	@ResponseBody
	public String create(HttpServletResponse response) {
		// ��Ű ����
		Cookie c = new Cookie("k01", "v01");
		
		c.setMaxAge(60 * 60 * 24);	// ���ӽð� 24�ð����� ����
		// ��� ���� ( �� �ش� ��ο��� ��Ű ����� �����ϰ� �� )
		c.setPath("/");
		
		// ��Ű ����
		response.addCookie(c);
		
		return "cookie create ";
	}
	
	// ��Ű ����
	@GetMapping("/delete")
	@ResponseBody
	public String delete(HttpServletResponse response) {
		Cookie c = new Cookie("k01", "v01");
		// ��� ���� ( �� �ش� ����� ��Ű �����ð� ������ ���� ���� )
		
		c.setPath("/");
		// cookie ������ �������� �����Ƿ� ��Ű ���� �ð��� 0�ʷ� ������ �ٷ� �������Բ� ��
		c.setMaxAge(0);
		
		// ��Ű����
		response.addCookie(c);
		
		return "cookie delete";
	}
	
	// ��Ű Ȯ��
	@GetMapping("/check")
	public String check(HttpServletResponse response) {
		return "cookie/check";
	}
	
	@GetMapping("/checkCtrl")
	@ResponseBody
	public String checkCtrl(@CookieValue(required = false) Cookie c) {	// CookieValue ������̼��� �̿��ؼ� Cookie���� �޾ƿ�
		if(c != null) {
			log.info(c.getValue());
		}
		
		return "cookie check at controller";
	}

}
