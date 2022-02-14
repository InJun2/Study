package com.kh.app.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.entity.MemberDto;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao dao;

	@Override
	public int join(MemberDto dto) throws Exception {
		// 회원가입 처리
		
		// 회원번호 // 시퀸스 nextval
		int no = dao.getMemberSeq();
		
		// insert 처리
		dto.setUserNo(no);
		int result = dao.insertMember(dto);
		
		return result;
	}
	
}
