package com.example.demo.board.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.repository.BoardRepository;

@Aspect
@Component
public class BoardAop {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardRepository repo;
	
	private String getPrincipal() {			// Context안의 principal값 String으로 출력
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}
	
	private boolean getAuthentication() {	// Context안의 인증권한에 "ROLE_ADMIN"이 있다면 true
		boolean result = false;
		
		List<GrantedAuthority> list = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority gaut : list) {
			if(gaut.equals(new SimpleGrantedAuthority("ROLE_ADMIN"))) 
				result= true;
		}
		
		return result;
	}
	
	@Pointcut("execution(* com..board.service.BoardServiceImpl.updateBoard(..))")		// 적용할 지점 혹인 범위, 현재 서비스의 0개이상의 파라미터를 가진 모든 메소드가 대상
	private void BoardUpdateTarget() { }
	
	@Pointcut("execution(* com..board.service.BoardServiceImpl.deleteBoard(..))")
	private void BoardDeleteTarget() { }
	
	@Pointcut("execution(* com..board.service.BoardServiceImpl.deleteUdminBoard(..))")
	private void AdminBoardDeleteTarget() { }
	
	
	@Around("BoardUpdateTarget()")		// Advice : 실제 부가기능 구현부 ( Before Advice, After returning, After throwing, After, Around 존재 )
	public Object BoardUpdateAop(ProceedingJoinPoint pjp) throws Throwable {
		BoardDto dto = (BoardDto) pjp.getArgs()[0];	// 해당 타겟의 메소드의 파라미터 값을 가져옴 (현재 updateBoard인 메소드가 하나고 BoardDto 타입임 )

		if(dto.getBoardWriter().equals(getPrincipal()) || getAuthentication()) {	// 가져온 파라미터의 작성자명과 현재 로그인 인증한 username이 같거나 관리자권한이면 success 출력
			pjp.proceed();
		}
		
		return pjp;
	}
	
	@Around("BoardDeleteTarget()")		// Advice : 실제 부가기능 구현부 ( Before Advice, After returning, After throwing, After, Around 존재 )
	public Object BoardDeleteAop(ProceedingJoinPoint pjp) throws Throwable {
		String deleteNo = (String) pjp.getArgs()[0];
		if(getPrincipal().equals(repo.selectBoardWriter(deleteNo)) || getAuthentication()) {	// 가져온 파라미터의 작성자명과 현재 로그인 인증한 username이 같거나 관리자권한이면 success 출력
			pjp.proceed();
		}

		return pjp;
	}

	@Around("AdminBoardDeleteTarget()")		// Advice : 실제 부가기능 구현부 ( Before Advice, After returning, After throwing, After, Around 존재 )
	public Object AdminBoardDeleteAop(ProceedingJoinPoint pjp) throws Throwable {
		if(getAuthentication()) {	// 가져온 파라미터의 작성자명과 현재 로그인 인증한 username이 같거나 관리자권한이면 success 출력
			pjp.proceed();
		}
		
		return pjp;
	}
	
}


