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
	
	// ��������Ʈ
	
	// ����Ʈ ��
	// �ش� ��ο� ������ �� �Ǿ��ִٸ� ������̼��� ���ʿ� ȭ��ǥ�� ����, �׷��� ������ ���� ���δ� ȭ��ǥ�� ���� ��
	// 1. ���� : ������̼����� ����
	/* - @Before 
	 * - @After
	 * - @AfterReturning
	 * - @AfterThrowing
	 * - @Around
	 */
	// 2. ��� : ��ȣ �ȿ��� ����
	/* - target : Ŭ���� ���� �Ǵ� �������̽� ����
	 * - within : ��Ű�� || Ŭ���� �� �޼ҵ�, ������ ��� Ȯ���Ϸ��� com.kh.app24.aop..* �� ���� �ۼ��ϸ� aop �Ʒ��� ��� class���� method ��� ����
	 * - execution : ���ϴ� �޼ҵ带 ������ ����, ǥ���� ( ���������� ��ȯ�� ��Ű����.Ŭ������.�޼ҵ��̸�( �Ű����� ) )
	 * - . : ���� ��Ű��, ..: ���� ��Ű���� ������Ű�� 
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
	
	// @Around : after, before �ΰ��� ���� ���� ����
	// ����Ÿ�� Object, �Ķ���� : ��������Ʈ, ���� : throwable�� ����� ��
	// joinPoint : ���
	// pointcut : 
	@Around("execution(* com..*Dao.te*(..))")	// public �� ���� ����, ��� ����Ÿ���� *�� ����, class �� method �� * �̿밡��, �Ű��������� *�� 1���̻�, ..�� 0�� �̻��� �ǹ���
	public Object myAdvice05(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("========== epalse ===========");
		// before ----
		long startTime = System.currentTimeMillis();
		// Ÿ�� �޼ҵ� ȣ��
		Object obj = jp.proceed();
		// after ----
		long endTime = System.currentTimeMillis();
		
		long epalse = endTime - startTime; 
		log.info("elapse : {} ms", epalse);
		
		return obj;
	}
	
}
