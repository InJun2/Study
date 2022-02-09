package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Main {
	// String vs StringBuilder vs StringBuffer 
	// String : 문자열의 변경이 적을 경우
	// StringBuilder : 문자열의 변경이 많을 경우, 동기화의 지원 X ( 단일쓰레드 성능은 StringBuffer 보다 좋음 )
	// StringBuffer : 문자열의 변경이 많을 경우, 동기화의 지원 O ( 멀티쓰레드 환경에서 안전성 )
	
	public static void main(String[] args) throws Exception {
		
//		1. URL 셋팅 ( 요청주소 + 파라미터들 셋팅, 항목요소에 필수와 옵션이 존재, 필수만 작성해도 사용 가능 )
//		2. URL 객체 생성 ( 1에서 만든 URL 이용해서 )
//		3. URL을 이용해서 커넥션 가져오기
//		4. request의 요청방식 (method), header 설정
//		5. 커넥션에서 inputStream 가져옴 ( BufferedReader로 변환 )
//		6. 5에서 가져온 스트림으로 데이터 한줄씩 읽기 ( 누적시키기 ) 
//		7. 사용한 자원들 ( BufferedReader, HttpURLConnection ) 정리 하기 ( 자원 반납 )
//		8. 누적한 String 확인

		String key = "공공데이터포털에서 받아온 개인의 인증키";
		
		// URL 세팅
		StringBuilder url = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo");
		url .append( "?" + "serviceKey=" + key); // 필수
		url .append( "&" + "returnType=xml");
		url .append( "&" + "numOfRows=100");
		url .append( "&" + "pageNo=1");
		url .append( "&" + "year=2020");	// 필수
		url .append( "&" + "itemCode=PM10");
		
		// URL 객체 생성
		URL urlObj = new URL(url.toString());
		
		// URL을 이용해 커넥션 가져오기 ( 커넥션을 http 로 캐스팅 )
		HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
		
		// request의 요청방식, header 설정
		conn.setRequestMethod("GET");
		conn.setRequestProperty("content-type", "application/json"); 
		
		// 커넥션에서 inputStream 가져옴 ( BufferedReader 로 변환 )
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		// 위의 스트림으로 데이터 한줄씩 읽고 누적시키기
		StringBuilder result= new StringBuilder();
		String line;
		while((line = br.readLine()) != null) {
			result.append(line);
		}
		
		// 사용한 자원들 정리하기 ( 스트림, 커넥션 )
		br.close();
		conn.disconnect();
		
		// 출력해서 확인
		System.out.println(result);
		
		 
	}
	
}
