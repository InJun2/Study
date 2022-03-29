package com.example.demo.security.authentication;

import java.io.IOException;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	                                        Authentication authentication) throws IOException {				// 이미 인증은 Provider에서 인증 성공하여 넘어왔으니 ContextHolder에 인증 정보 저장해 놓고 사용
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    
	    response.sendRedirect("/A");	// 해당 인증 권한 값에 따라 화면을 다르게 보내주자
	} 
}
