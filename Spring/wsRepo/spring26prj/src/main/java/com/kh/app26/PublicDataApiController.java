package com.kh.app26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class PublicDataApiController {
	
	@GetMapping("api-test")
	@ResponseBody
	public String apiTest() throws IOException {
		String result = apiCall();
		
		// Gson을 이용해서 단순한 문자열을 Json 형식( JsonObject ) 에 맞게 변경
		JsonObject resultObj = JsonParser.parseString(result).getAsJsonObject();
		System.out.println(resultObj);
		
		// Json 객체에서 키값을 이용해서 데이터 꺼내기
//		JsonObject responseObj = resultObj.get("response").getAsJsonObject();
		JsonObject responseObj = (JsonObject) resultObj.get("response");	// response value 가져오기
		System.out.println(responseObj);
		
		// responseObj에서 다시 키값을 이용하여 해당 value 가져오기
		JsonObject bodyObj = (JsonObject) responseObj.get("body");
		JsonObject headerObj = (JsonObject) responseObj.get("header");
		System.out.println(bodyObj + "\n" + headerObj);
		
		// 바디 > 2개 키값 에 해당하는 value 출력해보기
		String totalCount = bodyObj.get("totalCount").getAsString();
		System.out.println(totalCount);
		
		return "api call";
	}
	
	private String apiCall() throws IOException{
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=개인인증키"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode("2020", "UTF-8")); /*측정 연도*/
        urlBuilder.append("&" + URLEncoder.encode("itemCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*미세먼지 항목 구분(PM10, PM25), PM10/PM25 모두 조회할 경우 파라미터 생략*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
		return sb.toString();
	}
	
}
