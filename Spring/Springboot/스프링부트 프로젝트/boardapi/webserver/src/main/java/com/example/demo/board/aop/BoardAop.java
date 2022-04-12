package com.example.demo.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.service.BoardService;
import com.example.demo.security.authentication.AuthenticationMethod;

@Aspect
@Component
public class BoardAop {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private AuthenticationMethod auth;
	
	@Pointcut("execution(* com..board.service.BoardServiceImpl.updateBoard(..))")		// 적용할 지점 혹인 범위, 현재 서비스의 0개이상의 파라미터를 가진 모든 메소드가 대상
	private void BoardUpdateTarget() { }
	
	@Pointcut("execution(* com..board.service.BoardServiceImpl.deleteBoard(..))")
	private void BoardDeleteTarget() { }
	
	@Pointcut("execution(* com..board.service.BoardServiceImpl.deleteUdminBoard(..))")
	private void AdminBoardDeleteTarget() { }
	
	
	@Around("BoardUpdateTarget()")		// Advice : 실제 부가기능 구현부 ( Before Advice, After returning, After throwing, After, Around 존재 )
	public Object BoardUpdateAop(ProceedingJoinPoint pjp) throws Throwable {
		BoardDto dto = (BoardDto) pjp.getArgs()[0];	// 해당 타겟의 메소드의 파라미터 값을 가져옴 (현재 updateBoard인 메소드가 하나고 BoardDto 타입임 )

		if(auth.userCheck(dto.getBoardWriter())) {	// 가져온 파라미터의 작성자명과 현재 로그인 인증한 username이 같거나 관리자권한이면 success 출력
			Object result = pjp.proceed();
			return result;
		}
		
		throw new Throwable("게시글 업데이트 권한이 없습니다");
		
	}
	
	@Around("BoardDeleteTarget()")		// Advice : 실제 부가기능 구현부 ( Before Advice, After returning, After throwing, After, Around 존재 )
	public Object BoardDeleteAop(ProceedingJoinPoint pjp) throws Throwable {
		String deleteNo = (String) pjp.getArgs()[0];
		if(auth.getUserId().equals(service.selectBoardDetail(deleteNo).getBoardWriter()) || auth.getAuthentication()) {	// 가져온 파라미터의 작성자명과 현재 로그인 인증한 username이 같거나 관리자권한이면 success 출력
			Object result = pjp.proceed();
			return result;
		}

		throw new Throwable("게시글 삭제 권한이 없습니다");
	}

	@Around("AdminBoardDeleteTarget()")		// Advice : 실제 부가기능 구현부 ( Before Advice, After returning, After throwing, After, Around 존재 )
	public Object AdminBoardAop(ProceedingJoinPoint pjp) throws Throwable {
		if(auth.getAuthentication()) {	// 가져온 파라미터의 작성자명과 현재 로그인 인증한 username이 같거나 관리자권한이면 success 출력
			Object result = pjp.proceed();
			return result;
		}
		
		throw new Throwable("관리자가 아닙니다");
	}
	
}


