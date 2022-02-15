package com.kh.app.member.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public int join(MemberDto dto) throws Exception {
		// 회원가입 처리
		
		// 회원번호 // 시퀸스 nextval
		int no = dao.getMemberSeq();
		
		// insert 처리
		dto.setUserNo(no);
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
						
			// 파일을 서버에 저장
			File file = new File("D:/develop/06_FrameWork/wsRepo/springExprj/src/main/resources/upload/profile/" +f.getOriginalFilename());
			f.transferTo(file);
			
			// db에 insert
			dao.uploadProfile(dto);
			
		}
		
		return result;
	}
	
}
