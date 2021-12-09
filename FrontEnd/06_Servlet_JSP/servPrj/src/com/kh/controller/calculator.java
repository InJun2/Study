package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class calculator extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("value1"));
		int num2 = Integer.parseInt(req.getParameter("value2"));
		
		String btn = req.getParameter("btn");
		int result = 0;
		
		if(btn.equals("+")) {
			plus(num1,num2);
		}
		if(btn.equals("-")) {
			minus(num1,num2);
		}
		System.out.println("결과값 :" + result);
		
	}
	
	private int plus(int num1,int num2) {
		return num1+num2;
	}
	
	private int minus(int num1,int num2) {
		return num1+num2;
	}
}
