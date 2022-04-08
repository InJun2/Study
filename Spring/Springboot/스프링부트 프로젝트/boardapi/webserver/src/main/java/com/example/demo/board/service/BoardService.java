package com.example.demo.board.service;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;

import com.example.demo.board.dto.BoardDto;

public interface BoardService {

	List<BoardDto> selectBoardList() throws Exception;

	int insertBoard(BoardDto dto) throws Exception;

	BoardDto selectBoardDetail(String boardNo) throws Exception;

	boolean userCheck(BoardDto boardDto) throws Exception;

	void updateBoard(BoardDto dto) throws Exception;
	
	void deleteBoard(String deleteNo) throws Exception;

	void deleteUdminBoard(String deleteNoArr) throws Exception;

	JSONArray testResult() throws Exception;

	String updateTest(BoardDto dto) throws IOException;


}
