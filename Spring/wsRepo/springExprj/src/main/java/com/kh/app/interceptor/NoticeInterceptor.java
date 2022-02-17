package com.kh.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kh.app.member.entity.MemberDto;

// ���ͼ��͸���¹��2����
// 1. extend HandlerInterceptorAdapter 
// 2. implements HandlerInterceptorAdapter
public class NoticeInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MemberDto loginUser = (MemberDto) request.getSession().getAttribute("loginUser");
		
		if("admin".equals(loginUser.getUserId())) {
			return true;
		}	else {
//			response.sendRedirect(request.getServletContext().getContextPath());
			request.setAttribute("msg", "�����ڰ� �ƴմϴ�");
			request.getRequestDispatcher("/WEB-INF/views/error/errorPage.jsp").forward(request, response);
			return false;
		}
	}
}