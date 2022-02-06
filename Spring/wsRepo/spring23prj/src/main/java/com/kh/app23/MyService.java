package com.kh.app23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

	@Autowired
	private MyDao dao;
	
	@Transactional
	public void test() {
		dao.testA();
		dao.testB();
	}
	
}
