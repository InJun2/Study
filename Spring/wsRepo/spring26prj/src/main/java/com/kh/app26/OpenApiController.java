package com.kh.app26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
@RequestMapping("data")
public class OpenApiController {
	
	@GetMapping("mise")
	public String OpenApi() throws Exception {
		String result = callMise();
		
		JsonObject resultObj = JsonParser.parseString(result).getAsJsonObject();
		JsonObject responseObj = resultObj.getAsJsonObject("response");
		JsonObject bodyObj = responseObj.getAsJsonObject("body");
		JsonArray items = bodyObj.getAsJsonArray("items");
		
		System.out.println(responseObj);
		
		for(int i=0; i< items.size(); ++i) {
			System.out.println(items.get(i));
		}
		
		return "data/mise";
	}
	
	private String callMise() throws Exception{
		String key = "��������Ű";
		
		// URL ����
		StringBuilder url = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo");
		url .append( "?" + "serviceKey=" + key); // �ʼ�
		url .append( "&" + "returnType=json");
		url .append( "&" + "numOfRows=100");
		url .append( "&" + "pageNo=1");
		url .append( "&" + "year=2020");	// �ʼ�
		url .append( "&" + "itemCode=PM10");
		
		// URL ��ü ����
		URL urlObj = new URL(url.toString());
		
		// URL�� �̿��� Ŀ�ؼ� �������� ( Ŀ�ؼ��� http �� ĳ���� )
		HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
		
		// request�� ��û���, header ����
		conn.setRequestMethod("GET");
		conn.setRequestProperty("content-type", "application/json"); 
		
		// Ŀ�ؼǿ��� inputStream ������ ( BufferedReader �� ��ȯ )
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		// ���� ��Ʈ������ ������ ���پ� �а� ������Ű��
		StringBuilder result= new StringBuilder();
		String line;
		while((line = br.readLine()) != null) {
			result.append(line);
		}
		
		// ����� �ڿ��� �����ϱ� ( ��Ʈ��, Ŀ�ؼ� )
		br.close();
		conn.disconnect();
		
		// ����ؼ� Ȯ��
//		System.out.println(result);
		
		return result.toString();
	}
}
