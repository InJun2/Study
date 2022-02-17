package com.kh.app.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.app.notice.vo.NoticeVo;

@Repository
public class NoticeDaoImpl implements NoticeDao{
	
	@Autowired
	private SqlSession ss;

	@Override
	public int write(NoticeVo vo) throws Exception {
		return ss.insert("notice.insertNotice", vo);
	}

	@Override
	public List<NoticeVo> getNoticeList() throws Exception {
		return ss.selectList("notice.getNoticeList");
	}

	@Override
	public int deleteNotice(String[] delArr) throws Exception {
		return ss.update("notice.deleteNotice", delArr);
	}

}
