package com.example.neighbor.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {		// Aspect : 부가 기능 구현체들을 포함하고 있는 모듈
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("execution(* com..service..*(..))")		// 적용할 지점 혹인 범위, 현재 서비스의 0개이상의 파라미터를 가진 모든 메소드가 대상
	private void publicTarget() { }
	
	@Around("publicTarget()")		// Advice : 실제 부가기능 구현부 ( Before Advice, After returning, After throwing, After, Around 존재 )
	public Object calcPerformanceAdvice(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("성능 측정");
		StopWatch sw = new StopWatch();
		sw.start();

		Object result = pjp.proceed();		// 메인 로직 실행
		
		sw.stop();
		logger.info("측정 종료");
		logger.info("걸린시간 : {} ms", sw.getLastTaskTimeMillis());
		
		return result;
	}
	
}
