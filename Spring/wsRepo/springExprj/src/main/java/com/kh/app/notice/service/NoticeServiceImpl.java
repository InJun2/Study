package com.kh.app.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.notice.dao.NoticeDao;
import com.kh.app.notice.vo.NoticeVo;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDao dao;

	@Override
	public int write(NoticeVo vo) throws Exception {

		return dao.write(vo);
	}

	@Override
	public List<NoticeVo> getNoticeList() throws Exception {
		return dao.getNoticeList();
	}

	@Override
	public int deleteNotice(String str) throws Exception {
		String[] delArr = str.split(",");
		
		return dao.deleteNotice(delArr);
	}
	
}
