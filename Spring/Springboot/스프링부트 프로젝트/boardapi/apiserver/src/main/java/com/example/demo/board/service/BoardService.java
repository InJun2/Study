package com.example.demo.board.service;

import java.util.List;

import com.example.demo.board.dto.BoardDto;

public interface BoardService {

	List<BoardDto> selectBoardList() throws Exception;

	int insertBoard(BoardDto boardDto) throws Exception;

	BoardDto selectBoardDetail(String boardNo) throws Exception;

	int updateBoard(BoardDto dto) throws Exception;

	int deleteBoard(String deleteNo) throws Exception;

	int deleteUdminBoard(String deleteNoArr) throws Exception;

}
