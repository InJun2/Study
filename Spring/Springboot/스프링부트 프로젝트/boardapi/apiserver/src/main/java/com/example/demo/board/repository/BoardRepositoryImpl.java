package com.example.demo.board.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository{

	private final BoardMapper mapper;

	@Override
	public List<BoardDto> selectBoard() throws Exception {
		return mapper.selectBoard();
	}

	@Override
	public void updateBoardSeq() throws Exception {
		mapper.updateBoardSeq();
	}

	@Override
	public int insertBoard(BoardDto boardDto) throws Exception {
		return mapper.insertBoard(boardDto);
	}

	@Override
	public BoardDto selectBoardDetail(String boardNo) throws Exception {
		return mapper.selectBoardDetail(boardNo);
	}

	@Override
	public int updateBoard(BoardDto boardDto) throws Exception {
		return mapper.updateBoard(boardDto);
	}

	@Override
	public int deleteBoard(String deleteNo) throws Exception {
		return mapper.deleteBoard(deleteNo);
	}
}
