package com.example.demo.member.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.member.mapper.MemberMapper;
import com.example.demo.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberDaoImpl implements MemberDao{
	
	private final MemberMapper mapper;

	@Override
	public MemberVo selectId(String username) {
		return mapper.selectId(username);
	}

	@Override
	public int insertUser(MemberVo vo) {
		return mapper.join(vo);
	}

	@Override
	public int updateUserSeq() {
		return mapper.updateMemberSeq();
	}

}
