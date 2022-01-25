package com.kh.app14.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.app14.board.entity.BoardDto;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
	// 게시글 등록
	@Autowired
	private SqlSession ss;
	
	@Override
	public int insert(BoardDto dto) throws Exception {
		return ss.insert("board.insert", dto);
	}

	@Override
	public List<BoardDto> selectAll() {
		return ss.selectList("board.selectAll");
	}

	@Override
	public BoardDto selectOne(String title) {
		return ss.selectOne("board.selectOne", title);
	}

	@Override
	public int edit(BoardDto dto) {
		return ss.update("board.update", dto);
	}

	@Override
	public int delete(BoardDto dto) {
		return ss.delete("board.delete", dto);
	}

}
