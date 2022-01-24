package com.kh.app14.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.app14.member.entity.MemberDto;
import com.kh.app14.member.repository.MemberRepositoryInter;

@Component
public class MemberServiceImpl implements MemberServiceInter{

	@Autowired
	private MemberRepositoryInter repository;
	
	@Autowired
	private Member
	
	@Autowried
	private SqlSession ss;
	
	@Override
	public int join(MemberDto dto) {
		String newPwd = pe.encode(dto.getPwd());
		dto.setPwd(newPwd);
		
		return mrepo.join(dto);
	}

}
