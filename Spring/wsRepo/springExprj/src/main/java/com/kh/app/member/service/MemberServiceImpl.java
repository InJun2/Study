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
		// ȸ������ ó��
		
		// ȸ����ȣ // ������ nextval
		int no = dao.getMemberSeq();
		
		// insert ó��
		dto.setUserNo(no);
		int result = dao.insertMember(dto);
		
		///////////////
		
		// ���� ���ε� ( ������ ���� )
		MultipartFile f = dto.getF();
		// ������ ������ Ȯ��  
		if(!f.isEmpty()) {
			// ���� �̸�	: f.getOriginalFilename()
			// ������		: f.getSize()
			// Ÿ��		: f.getContentType()
			// ����� �̸�
			String changeName = System.currentTimeMillis() +"_" +f.getOriginalFilename();
			dto.setChangeName(changeName);
						
			// ������ ������ ����
			File file = new File("D:/develop/06_FrameWork/wsRepo/springExprj/src/main/resources/upload/profile/" +f.getOriginalFilename());
			f.transferTo(file);
			
			// db�� insert
			dao.uploadProfile(dto);
			
		}
		
		return result;
	}
	
}
