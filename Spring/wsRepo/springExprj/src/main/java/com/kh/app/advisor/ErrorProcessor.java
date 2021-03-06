package com.kh.app.advisor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(annotations = Controller.class)
@Slf4j
public class ErrorProcessor {
	
	@ExceptionHandler(Exception.class)
	public String errorProcess(Exception e) {
		log.error(e.toString());
//		e.printStackTrace();
		
		return "error/exception";
	}
}
