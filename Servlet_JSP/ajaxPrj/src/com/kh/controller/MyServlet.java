package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("myServlet doGet called");
		
		// 전달받은 데이터 받기
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		
		// 꺼낸데잍어 출력
		System.out.println(name);
		System.out.println(age);
		System.out.println(addr);
		
		// 응답 전달
		resp.setContentType("text/html; charset=UTF-8");
		
		if(Integer.parseInt(age) >= 20) {
			resp.getWriter().print("adult");
		}
		else {
			resp.getWriter().print("kid");
		}
		
		
	}
}
