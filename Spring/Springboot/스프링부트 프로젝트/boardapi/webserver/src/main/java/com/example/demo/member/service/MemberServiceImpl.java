package com.example.demo.member.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.dao.MemberDao;
import com.example.demo.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

	private final MemberDao dao;
	
	public BCryptPasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder(); 
	}

	@Override
	public MemberVo loginUser(MemberVo vo) {
		return decryptionPwd(vo);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class) 
	public int joinUser(MemberVo vo) {
		if(dao.updateUserSeq() > 0) {
			return dao.insertUser(encodingPwd(vo));
		}
		return 0;
	}
	
	private MemberVo encodingPwd(MemberVo vo) {
	     vo.setUserPwd(passwordEncoder().encode(vo.getUserPwd()));
	     return vo;
	}
	
	private MemberVo decryptionPwd(MemberVo vo) {
		if(dao.selectId(vo.getUserId())==null) {
			return null;
		}
		if(passwordEncoder().matches(vo.getUserPwd(), dao.selectId(vo.getUserId()).getUserPwd())) {
			vo = dao.selectId(vo.getUserId());
			return vo;
		}
		return null;
	}

	@Override
	public MemberVo checkId(String username) {
		return dao.selectId(username);
	}
}
