package com.example.demo.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardRepository repo;

	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return repo.selectBoard();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertBoard(BoardDto boardDto) throws Exception {
		repo.updateBoardSeq();
		return repo.insertBoard(boardDto);
	}

	@Override
	public BoardDto selectBoardDetail(String boardNo) throws Exception {
		return repo.selectBoardDetail(boardNo);
	}

	@Override
	public int updateBoard(BoardDto boardDto) throws Exception {
		return repo.updateBoard(boardDto);
	}

	@Override
	public int deleteBoard(String deleteNo) throws Exception {
		return repo.deleteBoard(deleteNo); 
	}

	@Override
	public int deleteUdminBoard(String deleteNoArr) throws Exception {
		int result = 0;
		String[] deleteNo = splitStrings(deleteNoArr);
		for(String delNo: deleteNo) {
			result += repo.deleteBoard(delNo);
		}
		
		return result;
	}
	
	private String[] splitStrings(String str) {
		return str.split(",");
	}

}
