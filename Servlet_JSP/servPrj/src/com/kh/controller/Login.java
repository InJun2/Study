package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// UTF-8 인코딩 방식으로 지정
		
		// 클라이언트 -> 서버 ( request )
		// 서버 -> 클라이언트 ( response )
		
		String id = request.getParameter("id");
		System.out.println("id : "+ id);
		
		
		PrintWriter out = response.getWriter();
		// 웹은 기본적으로 ISO-8859-1 이라서 1바이트씩 읽으나 한글은 2바이트이므로 깨지게됨
		
		out.println("<h1>서버에서 만든 글씨<h2>");
		
		if(id.equals("admin")) {
			out.println("관리자 입니다");
		}
		else{
			out.println("일반유저입니다");
		}
		
		out.flush();
		
	}
}
