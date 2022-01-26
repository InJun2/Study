package com.kh.app17.gallery.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.app17.gallery.vo.GalleryVo;

@Repository
public class GalleryDaoImpl implements GalleryDao{
	
	@Autowired
	private SqlSession ss;
	
	@Override
	public int getSeq() {
		return ss.selectOne("gallery.getSeq");
	}

	@Override
	public int insert(GalleryVo vo) {
		return 	ss.insert("gallery.enroll", vo);
	}
	
}
