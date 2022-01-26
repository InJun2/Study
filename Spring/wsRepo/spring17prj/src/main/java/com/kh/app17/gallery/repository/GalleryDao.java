package com.kh.app17.gallery.repository;

import com.kh.app17.gallery.vo.GalleryVo;

public interface GalleryDao {
	int getSeq();
	
	int insert(GalleryVo vo);
}
