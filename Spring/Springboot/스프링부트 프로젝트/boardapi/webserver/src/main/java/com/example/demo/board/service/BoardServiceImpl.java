package com.example.demo.board.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.security.authentication.AuthenticationMethod;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository repo;
	
	@Autowired
	private AuthenticationMethod auth;

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
		return boardDto.getBoardWriter().equals(auth.getUserId()) || auth.getAuthentication();
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

	@Override
	public String testResult() throws Exception {
		URL url = new URL("http://localhost:8446/board/list");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setDoOutput(true);
		
		try{
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			while(br.ready()) {
				sb.append(br.readLine());
			}
			String str =  sb.toString();	// Json 데이터 파싱하여 String 타입으로 변환 --> 이제 객체 컬렉션에 담을 예정
			
			JSONParser jsonParser = new JSONParser(str);
			Object obj = jsonParser.parse();
			JSONObject jsonObj = (JSONObject) obj;
			
			System.out.println(jsonObj);
//			Object obj = jsonParser.parse(str);
			
			return str;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "not found board list";
	}

	@Override
	public int updateTest(BoardDto dto) throws IOException {
		URL url = new URL("http://localhost:8446/board/update");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/json");
		
		
//		conn.setRequestProperty("boardNo", dto.getBoardNo());
//		conn.setRequestProperty("boardTitle", dto.getBoardTitle());
//		conn.setRequestProperty("boardContent", dto.getBoardContent());
//		conn.setRequestProperty("boardWriter", dto.getBoardWriter());
//		conn.setRequestProperty("boardDate", dto.getBoardDate().toString());
		conn.setDoOutput(true);
		
		try(BufferedReader br = new BufferedReader(
			new InputStreamReader(conn.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}
		
		return 0;
	}


}
