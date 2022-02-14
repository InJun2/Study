package com.kh.app.member.service;

import com.kh.app.member.entity.MemberDto;

public interface MemberService {
	int join(MemberDto dto) throws Exception;
}
