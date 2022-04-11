package com.example.demo.board.service;

import java.util.List;

import com.example.demo.board.dto.BoardDto;

public interface BoardService {

	int insertBoard(BoardDto dto) throws Exception;

	BoardDto selectBoardDetail(String boardNo) throws Exception;

	int updateBoard(BoardDto dto) throws Exception;
	
	int deleteBoard(String deleteNo) throws Exception;

	int deleteUdminBoard(String deleteNoArr) throws Exception;

	List<BoardDto> loadBoardList() throws Exception;


}
