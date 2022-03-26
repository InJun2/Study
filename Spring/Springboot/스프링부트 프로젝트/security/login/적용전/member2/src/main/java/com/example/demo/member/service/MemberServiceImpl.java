package com.example.demo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.dao.MemberDao;
import com.example.demo.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao dao;
	
	@Bean 
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
		if(dao.selectId(vo)==null) {
			return null;
		}
		if(passwordEncoder().matches(vo.getUserPwd(), dao.selectId(vo).getUserPwd())) {
			vo = dao.selectId(vo);
			return vo;
		}
		return null;
	}

	@Override
	public MemberVo checkId(MemberVo vo) {
		return dao.selectId(vo);
	}
}
