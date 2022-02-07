package com.kh.app24.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@EnableAspectJAutoProxy
@Component
@Aspect
@Slf4j
public class MyAspect {
	// advice
	
	// 조인포인트
	
	// 포인트 컷
	// 해당 경로에 연결이 잘 되어있다면 어노테이션의 왼쪽에 화살표가 생김, 그렇기 때문에 적용 여부는 화살표를 보면 됨
	// 1. 언제 : 어노테이션으로 설정
	/* - @Before 
	 * - @After
	 * - @AfterReturning
	 * - @AfterThrowing
	 * - @Around
	 */
	// 2. 대상 : 괄호 안에다 설정
	/* - target : 클래스 지정 또는 인터페이스 지정
	 * - within : 패키지 || 클래스 의 메소드, 하위를 모두 확인하려면 com.kh.app24.aop..* 과 같이 작성하면 aop 아래의 모든 class안의 method 모두 적용
	 * - execution : 원하는 메소드를 선택이 가능, 표현식 ( 접근제한자 반환형 패키지명.클래스명.메소드이름( 매개변수 ) )
	 * - . : 현재 패키지, ..: 현재 패키지와 하위패키지 
	 */
//	@Before("target(com.kh.app24.HomeController)")
	public void myAdvice01() {
		log.info("myAdvice called before home");
	}
	
//	@After("target(com.kh.app24.HomeController)")
	public void myAdvice02() {
		log.info("myAdvice called after home");
	}
	
//	@Before("target(com.kh.app24.aop.service.MyService)")
	public void myAdvice03() {
		log.info("myAdvice called before MyService");
	}
	
//	@After("target(com.kh.app24.aop.service.MyService)")
	public void myAdvice04() {
		log.info("currentTiem before MyService : " + System.currentTimeMillis());
	}
	
	// @Around : after, before 두개의 시점 간섭 가능
	// 리턴타입 Object, 파라미터 : 조인포인트, 예외 : throwable로 맞춰야 함
	// joinPoint : 대상
	// pointcut : 
	@Around("execution(* com..*Dao.te*(..))")	// public 은 생략 가능, 모든 리턴타입을 *로 지정, class 나 method 명도 * 이용가능, 매개변수에서 *는 1개이상, ..은 0개 이상을 의미함
	public Object myAdvice05(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("========== epalse ===========");
		// before ----
		long startTime = System.currentTimeMillis();
		// 타겟 메소드 호출
		Object obj = jp.proceed();
		// after ----
		long endTime = System.currentTimeMillis();
		
		long epalse = endTime - startTime; 
		log.info("elapse : {} ms", epalse);
		
		return obj;
	}
	
}
