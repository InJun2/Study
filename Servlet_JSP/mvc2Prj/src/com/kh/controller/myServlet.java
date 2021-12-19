package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.service.MyService;
import com.kh.vo.Member;

@WebServlet("/my")
public class myServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("123");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		Member member = new Member(id,pwd);
		
		MyService service = new MyService();
		service.sss(member);
	}
}
