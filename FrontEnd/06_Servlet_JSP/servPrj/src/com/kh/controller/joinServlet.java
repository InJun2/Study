package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class joinServlet extends HttpServlet{
	// join.html의 form의 action을 post로 지정해주었기 때문에 doPost 메소드를 사용하
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userId");
		String pwd = req.getParameter("userPwd");
		String email = req.getParameter("userEmail");
		String[] colors = req.getParameterValues("userColor");
		String gender = req.getParameter("gender");
		String age = req.getParameter("userAge");
		
		System.out.println("userId : " + id);
		System.out.println("userPwd : " + pwd);
		System.out.println("userEmail : " + email);
		System.out.println("userColor : ");
		for(int i=0;i<colors.length; i++) {
			System.out.print(colors[i]);
		}
		System.out.println("userGender : " + gender);
		System.out.println("userAge : " + age);
		
		
		
	}
}
