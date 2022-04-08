package com.example.demo.board.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.security.authentication.AuthenticationMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public JSONArray testResult() throws Exception {
		String str = requestBoardApi("board/list", "GET");
			
		return stringToJsonArr(str);
	}

	@Override
	public String updateTest(BoardDto dto) throws IOException {
		String result = requestBoardApi("board/update", "POST", dto);
		return result;
	}
	
	
	// 밑 메소드는 요청 관련 혹은 타입 변환 메소드
	private String requestBoardApi(String uri, String method) throws IOException{
		HttpURLConnection conn = settingConnection(uri, method);		// http 요청을 위해 특정 uri에 특정 method 연결을 위한 세팅
		return inputReadResponse(conn);		// 해당 uri에 세팅에 맞게 보낸 요청의 결과 읽어오기
	}
	
	private String requestBoardApi(String uri, String method, BoardDto dto) throws IOException{
		HttpURLConnection conn = settingConnection(uri, method);		// http 요청을 위해 특정 uri에 특정 method 연결을 위한 세팅
		conn = setParameterConnection(conn, dto);
		return inputReadResponse(conn);		// 해당 uri에 세팅에 맞게 보낸 요청의 결과 읽어오기
	}
	
	private HttpURLConnection settingConnection(String uri, String method) throws IOException {
		try {
			URL url = new URL("http://localhost:8446/"+uri);	// public static으로 선언해서 다른데서도 적용할지, 그냥 Bean 등록?
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method);	// 메소드 타입 유효성 검사도 해당 메소드 안에 존재
			conn.setRequestProperty("Content-type", "application/json");
			conn.setDoInput(true);
			
			return conn;
		}catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	private String inputReadResponse(HttpURLConnection conn) throws IOException {
		try {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			
			while(br.ready()) {
				sb.append(br.readLine());
			}
			br.close();
			conn.disconnect();

			return  sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private HttpURLConnection setParameterConnection(HttpURLConnection conn, BoardDto dto) throws IOException {		// apiserver에 파라미터 전송 목적
		conn.setDoOutput(true);
		try (DataOutputStream output = new DataOutputStream(conn.getOutputStream())) {
			
			output.writeBytes(objectToJsonString(dto));	// 여기서 JSON 형태의 string 타입으로 api server로 파라미터를 전송 ( 자세한 내용 모르겠음 )
			output.flush();
			
			return conn;
			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private JSONArray stringToJsonArr(String str) {
		return new JSONArray(str);	// 우선 Json Maven 임포트 ( jackson, simple-json 사용 x )
	}
	
	private JSONObject stringToJsonObj(String str) {
		return new JSONObject(str);
	}
	
	private String jsonToString(JSONArray jsonArr) {
		return jsonArr.toString();
	}
	
	private String objectToJsonString(Object obj) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.convertValue(obj, Map.class);
		return objectMapper.writeValueAsString(map);	// map을 스트링으로 변환 // JSON은 문자열은 ""가 붙어있어야하고 숫자는 ""가 없어야한다는 규칙이 존재 ( map.toString()은 규칙에 어긋남 )
	}

}
