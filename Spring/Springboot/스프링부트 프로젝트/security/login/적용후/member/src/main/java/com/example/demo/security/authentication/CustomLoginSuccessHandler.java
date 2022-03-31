package com.example.demo.security.authentication;

import java.io.IOException;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	                                        Authentication authentication) throws IOException {				// 이미 인증은 Provider에서 인증 성공하여 넘어왔으니 ContextHolder에 인증 정보 저장해 놓고 사용
	    
		List<GrantedAuthority> list = (List<GrantedAuthority>) authentication.getAuthorities();
	    
	    if(list.isEmpty()) {
	    	request.getSession().invalidate();
	    	log.error("회원 : " + authentication.getPrincipal() +" 잘못된 비밀번호 정보 접근");
	    	response.sendError(400, "잘못된 비번 입력");	// 비번이 일치하지 않아 isAuthenticated false 면서 권한이 비어있을경우
	    }
	    
	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    for(GrantedAuthority gauth : list) {
	    	if(gauth.equals(new SimpleGrantedAuthority("ROLE_ADMIN")))	
	    		redirectStrategy.sendRedirect(request, response, "/C");
	    	else if(gauth.equals(new SimpleGrantedAuthority("ROLE_A")))	
	    		redirectStrategy.sendRedirect(request, response, "/A");
	    	else if(gauth.equals(new SimpleGrantedAuthority("ROLE_B")))	
	    		redirectStrategy.sendRedirect(request, response, "/B");
	    	else {
	    		request.getSession().invalidate();
	    		log.error("잘못된 권한 정보");
		    	response.sendError(401, "잘못된 권한 정보");	// 지정된 권한이 아닐경우
	    	}
	    }
	    
	    
	} 
}
