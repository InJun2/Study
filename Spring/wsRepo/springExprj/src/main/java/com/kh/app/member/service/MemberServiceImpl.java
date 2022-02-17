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
		// ȸ������ ó��
		
		// ȸ����ȣ // ������ nextval
		int no = dao.getMemberSeq();
		
		// insert ó��
		dto.setUserNo(no);
		// ȸ�����Խ� ��ȣȭ
		dto.setUserPwd(pe.encode(dto.getUserPwd()));
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
			
			// webapp ���� profile ��ġ ����
			String path = req.getServletContext().getRealPath("/resources/upload/profile/");
						
			// ������ ������ ����
			File file = new File(path + changeName);
			f.transferTo(file);
			
			// db�� insert
			dao.uploadProfile(dto);
			
		}
		
		return result;
	}

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		// DB ���� ȸ�� ���� ��ȸ
		MemberDto dbUser = dao.getMember(dto);
		if(dbUser ==null) {
			return null;
		}
		
		// ��� üũ
		if(pe.matches(dto.getUserPwd(), dbUser.getUserPwd())) {
			// �α��� ����
			return dbUser;
		}else {
			return null;
		}
		
		
	}

	@Override
	public MemberDto editMember(MemberDto dto) throws Exception {
		// ��й�ȣ �ѹ� �� Ȯ��
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
