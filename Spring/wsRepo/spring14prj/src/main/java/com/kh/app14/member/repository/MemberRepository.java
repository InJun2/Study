package com.kh.app14.member.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.app14.member.entity.MemberDto;

@Repository
public class MemberRepository implements MemberRepositoryInter{
	
	@Autowired
	private SqlSession ss;
	
	public int join(MemberDto dto) {
		return ss.insert("member.join", dto);
	}
}
