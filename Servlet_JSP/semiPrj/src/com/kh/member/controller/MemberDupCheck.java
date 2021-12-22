package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

@WebServlet("/memberDupCheck")
public class MemberDupCheck extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ajax 요청");
		String k1 = req.getParameter("k1");
		String k2 = req.getParameter("k2");
		String id = req.getParameter("id");

		int result = new MemberService().dupCheck(id);
		
		if(result >0) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("사용불가");
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("사용가능");
		}
		
	}
}
