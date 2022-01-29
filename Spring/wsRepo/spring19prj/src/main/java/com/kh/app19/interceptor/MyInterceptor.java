package com.kh.app19.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 인터셉터 만드는 방법 2가지
// 1. HandlerInterceptor 인터페이스 상속
// 2. HandlerInterceptorAdapter 클래스 상속
public class MyInterceptor extends HandlerInterceptorAdapter{
	// servlet-context에서 interceptor의 exclude-mapping의 path 설정으로 특정 요청에 interceptor를 방지할 수 있다
	// 3가지 메소드
	// 1. handle 전
	// 2. handle 끝나고
	// 3. 화면으로 넘겨주기 전
	
	
	// 1. handle 전에
	// 리턴값에 따라 요청 통과시킬지 말지 결정 가능
	// 핸들러 : 처리할 메소드 정보 확인 가능
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle call .. \n"+handler);
		return true;
	}
	
	// 2. handle 끝나고
	// 리턴값이 없음, 끊을 수 없음
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle call..");
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	// 3. 화면 넘겨주기 전에
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion call..");
		System.out.println(ex);
		super.afterCompletion(request, response, handler, ex);
	}
	
}
