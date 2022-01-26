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
		// 파일 정보 vo 저장
		vo.setFname(f.getOriginalFilename());
		vo.setFtype(f.getContentType());
		vo.setFsize(f.getSize());
		
		// db에서 sequence 조회
		int no = dao.getSeq();
		vo.setNo(no);

		// db에 vo 저장
		int result = dao.insert(vo);
		
		// 파일만들기
		File file = new File("D:\\develop\\06_FrameWork\\wsRepo\\spring17prj\\src\\main\\webapp\\resources\\file", String.valueOf(no));
		// 파일 올리기
		f.transferTo(file);
		return result;
	}

}
