package com.kh.app14.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.app14.member.entity.MemberDto;
import com.kh.app14.member.repository.MemberRepository;

@Service
public class MemberService implements MemberServiceInter{
	
	@Autowired
	private MemberRepository mrepo;
	
	@Autowired
	private PasswordEncoder pe;			// spring-security

	public int join(MemberDto dto) {
		String newPwd = pe.encode(dto.getPwd());
		dto.setPwd(newPwd);
		
		return mrepo.join(dto);
	}
	
}
 