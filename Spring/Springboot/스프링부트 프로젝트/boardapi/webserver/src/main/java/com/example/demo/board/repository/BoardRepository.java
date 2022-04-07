package com.example.demo.board.repository;

import java.util.List;

import com.example.demo.board.dto.BoardDto;

public interface BoardRepository {

	List<BoardDto> selectBoard() throws Exception;

	void updateBoardSeq() throws Exception;

	int insertBoard(BoardDto dto) throws Exception;

	BoardDto selectBoardDetail(String boardNo) throws Exception;

	void updateBoard(BoardDto dto) throws Exception;

	void deleteBoard(String deleteBoardNoArr) throws Exception;
	
	String selectBoardWriter(String boardNo) throws Exception;

}
