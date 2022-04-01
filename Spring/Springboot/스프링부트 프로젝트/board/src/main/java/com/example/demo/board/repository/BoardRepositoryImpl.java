package com.example.demo.board.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.mapper.BoardMapper;

@Repository
public class BoardRepositoryImpl implements BoardRepository{
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public List<BoardDto> selectBoard() throws Exception {
		try {
			return mapper.selectBoard();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void updateBoardSeq() throws Exception {
		try {
			mapper.updateBoardSeq();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}		
	}
	
	@Override
	public int insertBoard(BoardDto dto) throws Exception {
		try {
		return mapper.insertBoard(dto);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public BoardDto selectBoardDetail(String boardNo) throws Exception {
		try {
			return mapper.selectBoardDetail(boardNo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void updateBoard(BoardDto dto) throws Exception {
		try {
			mapper.updateBoard(dto);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void deleteBoard(String boardNo) throws Exception {
		try {
			mapper.deleteBoard(boardNo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public String selectBoardWriter(String boardNo) throws Exception {
		try {
			return mapper.selectBoardWriter(boardNo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
