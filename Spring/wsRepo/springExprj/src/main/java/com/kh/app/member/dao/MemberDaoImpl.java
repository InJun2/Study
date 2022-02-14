package com.kh.app.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.app.member.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession ss;

	@Override
	public int getMemberSeq() throws Exception{
		return ss.selectOne("member.getSeq");
	}

	@Override
	public int insertMember(MemberDto dto) throws Exception{
		return ss.insert("member.insertMember", dto);
	}
	
}
