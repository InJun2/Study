package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Java파일 도착");		
		
		//getParameter
		String id = req.getParameter("id");
		System.out.println(id);
		
		//attribute 		// setAttribute(key, value)
		req.setAttribute("id", id);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/attrTest.jsp");
		dispatcher.forward(req, resp);
		//forward는 세팅한  request객체와 response객체를 전달
		
		System.out.println("Jsp로 전달");
	}
}
