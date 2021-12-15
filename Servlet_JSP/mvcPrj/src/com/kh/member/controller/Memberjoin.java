package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberJoin")
public class Memberjoin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost called");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		
		String model = "";
		if(Integer.parseInt(userAge) >=20){
			model = "성인";
		}else {
			model = "미성년";
		}	
		
		request.setAttribute("userId", userId);
		request.setAttribute("userPwd", userPwd);
		request.setAttribute("userName", userName);
		request.setAttribute("userAge", userAge);
		request.setAttribute("model", model);
		
		// foward와 redirect의 차이는 
		// 클라이언트 -> 서버로 요청 시에 foward는 서블릿에 도착 후 다른 서블릿에 요청을 보내고
		// redirect는 서블릿에 도착 후 다시 클라이언트로 돌아간 후에 해당 서블릿으로 클라이언트가 다시 요청하게 시킴
		
		// 링크가 index.jsp로 표기됨
//		resp.sendRedirect("/mvc/index.jsp");
		
		// 링크가 memberJoin으로 표기됨
//		req.getRequestDispatcher("index.jsp").forward(req,resp);
		
		// WEB-INF 안에 넣어서 forward를 이용해서 view 페이지를 숨김가능함, 클라이언트(브라우저에서)가 직접요청못함
		
		request.getRequestDispatcher("/WEB-INF/views/member/result.jsp").forward(request, response);
	}
}
