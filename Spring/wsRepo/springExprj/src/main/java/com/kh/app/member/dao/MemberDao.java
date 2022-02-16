package com.kh.app.member.dao;

import com.kh.app.member.entity.MemberDto;

public interface MemberDao {

	int getMemberSeq() throws Exception;

	int insertMember(MemberDto dto) throws Exception;

	void uploadProfile(MemberDto dto) throws Exception;

	MemberDto getMember(MemberDto dto) throws Exception;

	int updateMember(MemberDto dto) throws Exception;
	
}
