package com.example.demo.board.repository;

import java.util.List;

import com.example.demo.board.dto.BoardDto;

public interface BoardRepository {

	List<BoardDto> selectBoard() throws Exception;

	void updateBoardSeq() throws Exception;

	int insertBoard(BoardDto boardDto) throws Exception;

	BoardDto selectBoardDetail(String boardNo) throws Exception;

	int updateBoard(BoardDto boardDto) throws Exception;

	int deleteBoard(String deleteNo) throws Exception;

}
