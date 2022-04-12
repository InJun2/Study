package com.example.demo.board.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import com.example.demo.board.dto.BoardDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class BoardServiceImpl implements BoardService{
	
	final static String BOARD_API_SERVER = "https://localhost:8446/board/";
	
	@Override
	public List<BoardDto> loadBoardList() throws Exception {
		JSONArray jsonArr = new JSONArray(requestBoardApi("list", "GET"));	// jsonArray 형태의 스트링값을 받아와서 JsonArray로 변환 ( JSONArray는 List<HashMap<K,Y>> 형태 인듯 함 )
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		for(int i = 0; i< jsonArr.length(); i++) {	// for문 없이 boardDto를 파싱해서 컬렉션에 담을수는 없는지 ? 
			Gson gson = new Gson();
			BoardDto dto = gson.fromJson(jsonArr.getJSONObject(i).toString(), BoardDto.class);	// JsonArray의 값 하나씩 불러와서 BoardDto POJO로 역직렬화 하여 ArrayList<BoardDto>에 저장
			boardList.add(dto);
		}
		
		return boardList;
	}
	
	@Override
	public BoardDto selectBoardDetail(String boardNo) throws Exception {
		String jsonStr = requestBoardApi("detail/"+boardNo, "GET");
		return new ObjectMapper().readValue(jsonStr, BoardDto.class);	// jackson 역직렬화 ( json string -> POJO ) 
	}

	@Override
	public int insertBoard(BoardDto dto) throws Exception {
		return parseInt(requestBoardApi("insert","POST", dto));
	}
	
	@Override
	public int deleteBoard(String deleteNo) throws Exception {
		return parseInt(requestBoardApi("delete/"+deleteNo, "GET"));
	}	
	
	@Override
	public int deleteUdminBoard(String deleteNoArr) throws Exception {
		return parseInt(requestBoardApi("delete/admin/"+deleteNoArr, "DELETE"));
	}

	@Override
	public int updateBoard(BoardDto dto) throws Exception {
		String result = requestBoardApi("update", "POST", dto);
		return parseInt(result);
	}
	
	
	// 밑 메소드는 요청 관련 혹은 타입 변환 메소드
	private String requestBoardApi(String uri, String method) throws Exception{
		HttpsURLConnection conn = settingConnection(uri, method);		// http 요청을 위해 특정 uri에 특정 method 연결을 위한 세팅
		return inputReadResponse(conn);		// 해당 uri에 세팅에 맞게 보낸 요청의 결과 읽어오기
	}
	
	private String requestBoardApi(String uri, String method, Object obj) throws Exception{
		HttpsURLConnection conn = settingConnection(uri, method);		// http 요청을 위해 특정 uri에 특정 method 연결을 위한 세팅
		conn = setParameterConnection(conn, obj);
		return inputReadResponse(conn);		// 해당 uri에 세팅에 맞게 보낸 요청의 결과 읽어오기
	}
	
	private HttpsURLConnection settingConnection(String uri, String method) throws Exception {
		try {
			URL url = new URL(BOARD_API_SERVER + uri);	// 그냥 Bean 등록 할지?\
			ingoreSsl();
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod(method);	// 메소드 타입 유효성 검사도 해당 메소드 안에 존재
			conn.setRequestProperty("Content-type", "application/json");
			conn.setDoInput(true);
			
			return conn;
		}catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	

	private String inputReadResponse(HttpsURLConnection conn) throws IOException {
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
	
	private HttpsURLConnection setParameterConnection(HttpsURLConnection conn, Object obj) throws IOException {		// apiserver에 파라미터 전송 목적
		conn.setDoOutput(true);
		try (DataOutputStream output = new DataOutputStream(conn.getOutputStream())) {
			
			output.writeBytes(objectToJsonString(obj));	// 여기서 JSON 형태의 string 타입으로 api server로 파라미터를 전송 ( 자세한 내용 모르겠음 )
			output.flush();
			
			return conn;
			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private String objectToJsonString(Object obj) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();	// ObjectMapper 의 라이브러리는 Jackson
//		Map<String, Object> map = objectMapper.convertValue(obj, Map.class);	// 맵으로 바꿨다할 처리할 필요X --> 그냥 객체를 ObjectMapper로 Json 타입의 String으로 바로 변경
//		return objectMapper.writeValueAsString(map);	// map을 스트링으로 변환 // JSON은 문자열은 ""가 붙어있어야하고 숫자는 ""가 없어야한다는 규칙이 존재 ( map.toString()은 규칙에 어긋남 )
		return objectMapper.writeValueAsString(obj);
	}
	
	private int parseInt(String str) {
		return Integer.parseInt(str);
	}

	private static void ingoreSsl() throws KeyManagementException, NoSuchAlgorithmException{				// 아래 부터는 ssl 우회하기 위한 메소드 ( 구조 모름 )
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};
		trustAllHttpsCertificates();	// 모든 htts 인증서 신뢰
		HttpsURLConnection.setDefaultHostnameVerifier(hv);	// 호스트 이름 기본 확인자 설정
	}
	
	private static void trustAllHttpsCertificates() throws NoSuchAlgorithmException, KeyManagementException {
		TrustManager[] trustAllCerts = new TrustManager[1];
		TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}
	
}
	class miTM implements TrustManager, X509TrustManager{
		 public X509Certificate[] getAcceptedIssuers() {
	        return null;
	     }
	 
	     public boolean isServerTrusted(X509Certificate[] certs) {
	        return true;
	     }
	 
	     public boolean isClientTrusted(X509Certificate[] certs) {
	        return true;
	     }
	 
	     public void checkServerTrusted(X509Certificate[] certs, String authType)
	    	throws CertificateException {
	    	 	return;
	      }
	 
	     public void checkClientTrusted(X509Certificate[] certs, String authType)
	        throws CertificateException {
	    	 	return;
	     }

	}
