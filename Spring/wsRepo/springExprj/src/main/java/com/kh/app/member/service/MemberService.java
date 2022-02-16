package com.kh.app.member.service;

import javax.servlet.http.HttpServletRequest;

import com.kh.app.member.entity.MemberDto;

public interface MemberService {
	int join(MemberDto dto, HttpServletRequest req) throws Exception;

	MemberDto login(MemberDto dto) throws Exception;

	MemberDto editMember(MemberDto dto) throws Exception;
}
