package com.example.demo.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.security.user.CustomUserDetails;
import com.example.demo.security.userservice.CustomUserDetailsService;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private CustomUserDetailsService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication; // AuthenticaionFilter에서 생성된 토큰으로부터 아이디와 비밀번호를 조회함 ( 현재는 CustomAuthenticationFilter )
		String userId = token.getPrincipal().toString();
		String userPassword = token.getCredentials().toString();	// null 값이 들어가서 오류 발생
		
		CustomUserDetails user = userService.loadUserByUsername(userId);	// db에서 가져온 유저정보
		
		if(passwordEncoder().matches(userPassword, user.getPassword())){	// 인증
			log.info(user.getUsername() + " 회원 로그인 성공");
			token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());	// 인증 권한과 authenticated true로 새로운 토큰 생성
		}
		
		return token;
	}	

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
