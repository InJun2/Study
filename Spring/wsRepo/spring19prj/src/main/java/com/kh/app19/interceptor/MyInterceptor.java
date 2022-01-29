package com.kh.app19.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// ���ͼ��� ����� ��� 2����
// 1. HandlerInterceptor �������̽� ���
// 2. HandlerInterceptorAdapter Ŭ���� ���
public class MyInterceptor extends HandlerInterceptorAdapter{
	// servlet-context���� interceptor�� exclude-mapping�� path �������� Ư�� ��û�� interceptor�� ������ �� �ִ�
	// 3���� �޼ҵ�
	// 1. handle ��
	// 2. handle ������
	// 3. ȭ������ �Ѱ��ֱ� ��
	
	
	// 1. handle ����
	// ���ϰ��� ���� ��û �����ų�� ���� ���� ����
	// �ڵ鷯 : ó���� �޼ҵ� ���� Ȯ�� ����
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle call .. \n"+handler);
		return true;
	}
	
	// 2. handle ������
	// ���ϰ��� ����, ���� �� ����
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle call..");
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	// 3. ȭ�� �Ѱ��ֱ� ����
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion call..");
		System.out.println(ex);
		super.afterCompletion(request, response, handler, ex);
	}
	
}
