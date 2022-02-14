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
		// ȸ������ ó��
		
		// ȸ����ȣ // ������ nextval
		int no = dao.getMemberSeq();
		
		// insert ó��
		dto.setUserNo(no);
		int result = dao.insertMember(dto);
		
		return result;
	}
	
}
