package com.example.demo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository repo;
	
	private boolean getAuthentication() {	// Context안의 인증권한에 "ROLE_ADMIN"이 있다면 true
		boolean result = false;
		
		List<GrantedAuthority> list = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority gaut : list) {
			if(gaut.equals(new SimpleGrantedAuthority("ROLE_ADMIN"))) 
				result= true;
		}
		return result;
	}

	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return repo.selectBoard();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertBoard(BoardDto dto) throws Exception {
		repo.updateBoardSeq();
		return repo.insertBoard(dto);
	}


	@Override
	public BoardDto selectBoardDetail(String boardNo) throws Exception {
		return repo.selectBoardDetail(boardNo);
	}

	@Override
	public boolean userCheck(BoardDto boardDto) throws Exception {
		return boardDto.getBoardWriter().equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString()) || getAuthentication();
	}

	@Override
	public void updateBoard(BoardDto dto) throws Exception {
		repo.updateBoard(dto);
	}

	@Override
	public void deleteBoard(String deleteNo) throws Exception {
		repo.deleteBoard(deleteNo);
	}	
	
	@Override
	public void deleteUdminBoard(String deleteNoArr) throws Exception {
		String[] deleteBoardNoArr = splitString(deleteNoArr);
		for(int i=0; i < deleteBoardNoArr.length; i++) {
			repo.deleteBoard(deleteBoardNoArr[i]);
		}
	}
	
	private String[] splitString(String string) {
		return string.split(",");
	}


}
