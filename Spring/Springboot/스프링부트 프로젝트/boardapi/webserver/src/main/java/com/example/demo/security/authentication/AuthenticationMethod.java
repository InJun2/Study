package com.example.demo.security.authentication;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMethod {
	
	public boolean getAuthentication() {	// Context안의 인증권한에 "ROLE_ADMIN"이 있다면 true
		boolean result = false;
		
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> list = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		for(GrantedAuthority gaut : list) {
			if(gaut.equals(new SimpleGrantedAuthority("ROLE_ADMIN"))) 
				result= true;
		}
		return result;
	}
	
	public String getUserId() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}

}
