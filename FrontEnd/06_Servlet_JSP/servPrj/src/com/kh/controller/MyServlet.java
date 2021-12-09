package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/qqq")
public class MyServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		super.doGet(req, resp);
	}
	// 웹에서 해당 사이트에 /qqq를 입력하면 서버에 doget이 출력됨	(클라이언트가 서버에 요청을 보냄)
	
}
