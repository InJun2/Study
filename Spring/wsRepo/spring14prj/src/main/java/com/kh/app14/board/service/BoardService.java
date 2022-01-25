package com.kh.app14.board.service;

import java.util.List;

import com.kh.app14.board.entity.BoardDto;

public interface BoardService {
	
	int enrollBoard(BoardDto dto) throws Exception;

	List<BoardDto> selectBoard();

	BoardDto selectBoardDetail(String title);

	int edit(BoardDto dto);

	int delete(BoardDto dto);
}
