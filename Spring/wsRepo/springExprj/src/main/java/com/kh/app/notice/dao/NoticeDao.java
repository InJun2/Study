package com.kh.app.notice.dao;

import java.util.List;

import com.kh.app.common.PageVo;
import com.kh.app.notice.vo.NoticeVo;

public interface NoticeDao {

	int write(NoticeVo vo) throws Exception;

	List<NoticeVo> getNoticeList(PageVo vo) throws Exception;

	int deleteNotice(String[] delArr) throws Exception;

	int getNoticeCnt() throws Exception;
	
}
