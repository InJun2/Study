package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app")
public class AppContextServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext application = req.getServletContext();

		application.setAttribute("id", "hwang");
		// 반환값이 Object 이므로 캐스팅
		String x = String.valueOf(application.getAttribute("id"));
		
		System.out.println("어플리케이션 영역에서 가져온 아이디 : " + x);
		
	}
}
