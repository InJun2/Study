package com.kh.service;

import com.kh.vo.Member;
import com.kr.dao.MyDao;

public class MyService {
	public void sss(Member member) {
		System.out.println("Service > sss called");
		
		MyDao dao = new MyDao();
		dao.ddd(member);
	}
}
