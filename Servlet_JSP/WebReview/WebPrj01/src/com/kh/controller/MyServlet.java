package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// WebServlet 대신 web.xml에서 servlet mapping 해서 사용
public class MyServlet extends HttpServlet{
	// 톰캣안에 ws와 was 존재
	
	// 서블릿의 생명주기 ( life cycle )
	// init은 처음 해당 class를 읽어올때만 실행 ( 새로고침을 이용시 doGet만 호출됨 )
	@Override
	public void init() throws ServletException {
		System.out.println("init called...");
	}
	
	// 별로 사용되지 않지만 init이후 method가 아닌 service로 이동됨
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service called...");
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget called...");
		RequestDispatcher x = req.getRequestDispatcher("/index.jsp");
		x.forward(req, resp);
		
//		resp.sendRedirect(""); 
		// redirect는 req를 전달해주지 않는다 ( 클라이언트가 새로 요청을 하는지 여부 = req,resp 객체가 새로 생성되는지 여부 )
		
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html; charset=UTF-8");
//		resp.getWriter().write("한글 출력하는 방법");
	}
	
	// destroy는 톰캣 종료시 동작
	@Override
	public void destroy() {
		System.out.println("destroy called...");
	}
}
