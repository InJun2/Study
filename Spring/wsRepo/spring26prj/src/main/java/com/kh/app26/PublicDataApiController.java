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
		
		// Gson�� �̿��ؼ� �ܼ��� ���ڿ��� Json ����( JsonObject ) �� �°� ����
		JsonObject resultObj = JsonParser.parseString(result).getAsJsonObject();
		System.out.println(resultObj);
		
		// Json ��ü���� Ű���� �̿��ؼ� ������ ������
//		JsonObject responseObj = resultObj.get("response").getAsJsonObject();
		JsonObject responseObj = (JsonObject) resultObj.get("response");	// response value ��������
		System.out.println(responseObj);
		
		// responseObj���� �ٽ� Ű���� �̿��Ͽ� �ش� value ��������
		JsonObject bodyObj = (JsonObject) responseObj.get("body");
		JsonObject headerObj = (JsonObject) responseObj.get("header");
		System.out.println(bodyObj + "\n" + headerObj);
		
		// �ٵ� > 2�� Ű�� �� �ش��ϴ� value ����غ���
		String totalCount = bodyObj.get("totalCount").getAsString();
		System.out.println(totalCount);
		
		return "api call";
	}
	
	private String apiCall() throws IOException{
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=��������Ű"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml �Ǵ� json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*�� ������ ��� ��*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*��������ȣ*/
        urlBuilder.append("&" + URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode("2020", "UTF-8")); /*���� ����*/
        urlBuilder.append("&" + URLEncoder.encode("itemCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*�̼����� �׸� ����(PM10, PM25), PM10/PM25 ��� ��ȸ�� ��� �Ķ���� ����*/
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
