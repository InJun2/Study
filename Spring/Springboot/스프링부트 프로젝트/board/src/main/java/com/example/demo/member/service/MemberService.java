package com.example.demo.member.service;

import com.example.demo.member.vo.MemberVo;

public interface MemberService {

	MemberVo loginUser(MemberVo vo);

	int joinUser(MemberVo vo);

	MemberVo checkId(String username);
	
}
