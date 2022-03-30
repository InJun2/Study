package com.example.demo.member.dao;

import com.example.demo.member.vo.MemberVo;

public interface MemberDao {

	int insertUser(MemberVo vo);

	int updateUserSeq();

	MemberVo selectId(String username);

}