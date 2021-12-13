package com.kh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//에러 발생시 ctrl 1 눌르면 에러수정 방안이 나옴, 메소드 생성
@WebFilter("/*")
public class EncodeFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("필터 도착");
		request.setCharacterEncoding("UTF-8");
		
		// chain을 이용하여 필터를 통과해서 전달
		chain.doFilter(request, response);
		System.out.println("필터 통과");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
}
