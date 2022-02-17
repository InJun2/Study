package com.kh.app.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.entity.MemberDto;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private PasswordEncoder pe;

	@Override
	public int join(MemberDto dto, HttpServletRequest req) throws Exception {
		// 회원가입 처리
		
		// 회원번호 // 시퀸스 nextval
		int no = dao.getMemberSeq();
		
		// insert 처리
		dto.setUserNo(no);
		// 회원가입시 암호화
		dto.setUserPwd(pe.encode(dto.getUserPwd()));
		int result = dao.insertMember(dto);
		
		///////////////
		
		// 파일 업로드 ( 서버에 저장 )
		MultipartFile f = dto.getF();
		// 파일이 없는지 확인  
		if(!f.isEmpty()) {
			// 원래 이름	: f.getOriginalFilename()
			// 사이즈		: f.getSize()
			// 타입		: f.getContentType()
			// 변경된 이름
			String changeName = System.currentTimeMillis() +"_" +f.getOriginalFilename();
			dto.setChangeName(changeName);
			
			// webapp 안의 profile 위치 지정
			String path = req.getServletContext().getRealPath("/resources/upload/profile/");
						
			// 파일을 서버에 저장
			File file = new File(path + changeName);
			f.transferTo(file);
			
			// db에 insert
			dao.uploadProfile(dto);
			
		}
		
		return result;
	}

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		// DB 에서 회원 정보 조회
		MemberDto dbUser = dao.getMember(dto);
		if(dbUser ==null) {
			return null;
		}
		
		// 비번 체크
		if(pe.matches(dto.getUserPwd(), dbUser.getUserPwd())) {
			// 로그인 성공
			return dbUser;
		}else {
			return null;
		}
		
		
	}

	@Override
	public MemberDto editMember(MemberDto dto) throws Exception {
		// 비밀번호 한번 더 확인
		if(dto.getUserPwd().length() >0) {
			dto.setUserPwd(pe.encode(dto.getUserPwd()));			
		}
		
		int result = dao.updateMember(dto);
		
		MemberDto member = null;
		if(result>0) {
			member = dao.getMember(dto);
		}
		
		return member;
	}
	
}
