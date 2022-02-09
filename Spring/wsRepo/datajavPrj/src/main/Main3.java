package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main3 {
	public static void main(String[] args) throws Exception {
String key = "공공데이터포털에서 받아온 개인의 인증키";
		
		// URL 세팅
		StringBuilder url = new StringBuilder("http://apis.data.go.kr/6260000/PublicArt/getPublicArtInfo");
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
