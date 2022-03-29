package com.example.demo.security.authentication;

import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}
	
	 @Override
	 public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {	// 이거 실행 어디서 하는지?
		 UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(request.getParameter("userId"), request.getParameter("userPwd"));	// setAuthenticated false 값으로 인증 객체 생성
	     setDetails(request, authRequest);			// AuthentcationDetailsSource를 통해 만들어짐. 이는 WebAuthenticationDetails를 반환함. WebAuthenticationDetails는 remoteAddress와 sessionId(null)를 저장
	     return this.getAuthenticationManager().authenticate(authRequest);		// 해당 메소드는 interface로 구현되어 있어 알맞는 Provider(현재는 만들어둔 CustomAuthenticationProvider)를 찾아 (그런데 어떻게 찾는지 ?) authenticate로직을 실행하고 성공 실패 결과에 따른 추가적인 작업은 Handler 등록을 통해 작업이 가능 하다고 함
	}
}
