package com.kh.app17.gallery.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app17.gallery.repository.GalleryDao;
import com.kh.app17.gallery.vo.GalleryVo;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	private GalleryDao dao;

	@Override
	public int enroll(GalleryVo vo, MultipartFile f) throws IllegalStateException, IOException {
		// ���� ���� vo ����
		vo.setFname(f.getOriginalFilename());
		vo.setFtype(f.getContentType());
		vo.setFsize(f.getSize());
		
		// db���� sequence ��ȸ
		int no = dao.getSeq();
		vo.setNo(no);

		// db�� vo ����
		int result = dao.insert(vo);
		
		// ���ϸ����
		File file = new File("D:\\develop\\06_FrameWork\\wsRepo\\spring17prj\\src\\main\\webapp\\resources\\file", String.valueOf(no));
		// ���� �ø���
		f.transferTo(file);
		return result;
	}

}
