package com.kh.app20.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice(basePackages = "com.kh.app20") // �ش� ��� ������ ��Ű���� ����, {}�� ���� ��Ű�� ���� ����
@ControllerAdvice(annotations = Controller.class)	// annotations �� �̿��ؼ� @Controller�� ����ϴ� Ŭ���� ����, Contoller�� spring import
public class MyControllerAdvisor {
	
	@ExceptionHandler(RuntimeException.class)	// ���� �������� Runtime�ȿ� ���Ե�
	public String method01(RuntimeException e) {
		System.out.println("===================");
		e.printStackTrace();
		return "error/runtime";
	}
	
//	@ExceptionHandler(NullPointerException.class)	// ������ ���
//	public String method01(NullPointerException e) {
//		System.out.println("===================");
//		e.printStackTrace();
//		return "error/npe";
//	}
//	
//	@ExceptionHandler(ArithmeticException.class)	// ������ ���
//	public String method01(ArithmeticException e) {
//		System.out.println("===================");
//		e.printStackTrace();
//		return "error/zero";
//	}
//	
//	@ExceptionHandler(NumberFormatException.class)	// ������ ���
//	public String method01(NumberFormatException e) {
//		System.out.println("===================");
//		e.printStackTrace();
//		return "error/number";
//	}
	
}
