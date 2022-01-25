package com.kh.app14.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app14.board.entity.BoardDto;
import com.kh.app14.board.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository dao;
	
	@Override
	public int enrollBoard(BoardDto dto) throws Exception {
		int result = dao.insert(dto);
		// 게시글 등록, 실행 결과 반환
		return result;
	}

	@Override
	public List<BoardDto> selectBoard() {
		return dao.selectAll();
	}

	@Override
	public BoardDto selectBoardDetail(String title) {
		return dao.selectOne(title);
	}

	@Override
	public int edit(BoardDto dto) {
		return dao.edit(dto);
	}

	@Override
	public int delete(BoardDto dto) {
		return dao.delete(dto);
	}
}
