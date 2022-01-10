package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// WebServlet ��� web.xml���� servlet mapping �ؼ� ���
public class MyServlet extends HttpServlet{
	// ��Ĺ�ȿ� ws�� was ����
	
	// ������ �����ֱ� ( life cycle )
	// init�� ó�� �ش� class�� �о�ö��� ���� ( ���ΰ�ħ�� �̿�� doGet�� ȣ��� )
	@Override
	public void init() throws ServletException {
		System.out.println("init called...");
	}
	
	// ���� ������ ������ init���� method�� �ƴ� service�� �̵���
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
		// redirect�� req�� ���������� �ʴ´� ( Ŭ���̾�Ʈ�� ���� ��û�� �ϴ��� ���� = req,resp ��ü�� ���� �����Ǵ��� ���� )
		
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html; charset=UTF-8");
//		resp.getWriter().write("�ѱ� ����ϴ� ���");
	}
	
	// destroy�� ��Ĺ ����� ����
	@Override
	public void destroy() {
		System.out.println("destroy called...");
	}
}
