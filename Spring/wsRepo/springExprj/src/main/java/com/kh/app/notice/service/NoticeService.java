package com.kh.app.notice.service;

import java.util.List;

import com.kh.app.common.PageVo;
import com.kh.app.notice.vo.NoticeVo;

public interface NoticeService {

	int write(NoticeVo vo) throws Exception;

	List<NoticeVo> getNoticeList(PageVo vo) throws Exception;

	int deleteNotice(String str) throws Exception;

	int getNoticeCnt() throws Exception;
	
}
