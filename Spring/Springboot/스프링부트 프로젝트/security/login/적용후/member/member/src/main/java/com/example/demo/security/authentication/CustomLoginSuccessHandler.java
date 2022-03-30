package com.example.demo.security.authentication;

import java.io.IOException;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	                                        Authentication authentication) throws IOException {				// 이미 인증은 Provider에서 인증 성공하여 넘어왔으니 ContextHolder에 인증 정보 저장해 놓고 사용
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    		// redirectStratgy 를 이용한 redirect로 변경 예정
	    List<GrantedAuthority> list = (List<GrantedAuthority>) authentication.getAuthorities();
	    
	    if(list.isEmpty()) {
	    	request.getSession().invalidate();
	    	response.sendError(400, "잘못된 비번 입력");
	    }
	    
	    for(GrantedAuthority gauth : list) {
	    	if(gauth.equals(new SimpleGrantedAuthority("ROLE_A")))	
	    		response.sendRedirect("/A");
	    	else if(gauth.equals(new SimpleGrantedAuthority("ROLE_B")))	
	    		response.sendRedirect("/B");
	    	else if(gauth.equals(new SimpleGrantedAuthority("ROLE_ADMIN")))	
	    		response.sendRedirect("/C");	    
	    }
	} 
}
