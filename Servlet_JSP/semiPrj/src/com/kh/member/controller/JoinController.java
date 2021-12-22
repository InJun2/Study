package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.MemberVo;
import com.kh.member.model.service.MemberService;

@WebServlet("/join")
public class JoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		
		MemberVo m = new MemberVo();
		m.setId(id);
		m.setName(name);
		m.setPwd(pwd);
		
		int result = new MemberService().join(m);
		
		if(result>0) {
			req.setAttribute("msg", "회원가입 성공");
			req.getRequestDispatcher("WEB-INF/views/common/successPage.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "회원가입 실패");
			req.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}
