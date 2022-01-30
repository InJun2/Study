package com.kh.app20.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice(basePackages = "com.kh.app20") // 해당 경로 하위의 패키지들 감시, {}로 여러 패키지 감시 가능
@ControllerAdvice(annotations = Controller.class)	// annotations 를 이용해서 @Controller를 사용하는 클래스 감시, Contoller는 spring import
public class MyControllerAdvisor {
	
	@ExceptionHandler(RuntimeException.class)	// 많은 에러들이 Runtime안에 포함됨
	public String method01(RuntimeException e) {
		System.out.println("===================");
		e.printStackTrace();
		return "error/runtime";
	}
	
//	@ExceptionHandler(NullPointerException.class)	// 감시할 대상
//	public String method01(NullPointerException e) {
//		System.out.println("===================");
//		e.printStackTrace();
//		return "error/npe";
//	}
//	
//	@ExceptionHandler(ArithmeticException.class)	// 감시할 대상
//	public String method01(ArithmeticException e) {
//		System.out.println("===================");
//		e.printStackTrace();
//		return "error/zero";
//	}
//	
//	@ExceptionHandler(NumberFormatException.class)	// 감시할 대상
//	public String method01(NumberFormatException e) {
//		System.out.println("===================");
//		e.printStackTrace();
//		return "error/number";
//	}
	
}
