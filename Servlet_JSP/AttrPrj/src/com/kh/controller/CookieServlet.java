package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("num","1");
		
		// abc경로로 올때만 사용할수있는 쿠키설정 ( 경로 설정 )
		cookie.setPath("/abc");
		// 하루가 지나면 만료되는 쿠키설정 ( 만료시간 설정 )
		cookie.setMaxAge(60*60*24);
		
		resp.addCookie(cookie);
		
		System.out.println("cookie");
	}
}
