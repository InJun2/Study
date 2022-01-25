package com.kh.app14.board.repository;

import java.util.List;

import com.kh.app14.board.entity.BoardDto;


public interface BoardRepository {
	int insert(BoardDto dto) throws Exception;

	List<BoardDto> selectAll();

	BoardDto selectOne(String title);

	int edit(BoardDto dto);

	int delete(BoardDto dto);
	
}
