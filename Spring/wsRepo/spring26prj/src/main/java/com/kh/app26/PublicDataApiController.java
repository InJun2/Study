package com.kh.app26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class PublicDataApiController {
	
	@GetMapping("api-test")
	@ResponseBody
	public String apiTest() throws IOException {
		String result = apiCall("10");
		
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
		
		// body��� json object �ȿ��� items Ű���� �ش��ϴ� value ����غ���
//		JsonArray items = bodyObj.get("items").getAsJsonArray();	// �޼ҵ�� ó��
		JsonArray items = (JsonArray) bodyObj.get("items");			// casting ���� ó��
		
		System.out.println("--------------------------------------");
		List<ItemVo> itemVoList = new ArrayList<ItemVo>();
		for(int i=0; i< items.size(); ++i) {		
			JsonObject item = items.get(i).getAsJsonObject();
			String clearVal = item.get("clearVal").getAsString();
			String sn = item.get("sn").getAsString();
			String districtName = item.get("districtName").getAsString();
			String dataDate = item.get("dataDate").getAsString();
			String issueVal = item.get("issueVal").getAsString();
			
			ItemVo vo = new ItemVo();
			vo.setClearVal(clearVal);
			vo.setDataDate(dataDate);
			vo.setDistrictName(districtName);
			vo.setIssueVal(issueVal);
			vo.setSn(sn);
			
			itemVoList.add(vo);
		}
		
		for(ItemVo x : itemVoList) {			
			System.out.println(x);
		}
		
		return "api call";
	}
	
	@GetMapping("api-view")
	public String resp() {
		return "data/apiView2";
	}
	
	@GetMapping(value = "api-resp", produces = "text/xml; charset=utf-8")
	@ResponseBody
	public String apiResp(String numOfRows) throws IOException {
		
		// api ȣ��
		String result = apiCall(numOfRows);
		
		// ȣ���� ����
		return result;
	}
	
//	@GetMapping(value = "api-resp")		 // @GetMapping(value = "api-resp", produces = "application/json; charset=utf-8" �� ����
//	@ResponseBody
//	public ResponseEntity<String> apiResp(String id, String pwd) throws IOException {
//		
//		// api ȣ��
//		String result = apiCall();
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-type", "application/json; charset=utf-8");
//		
//		// ȣ���� ����
//		return new ResponseEntity<String>(result, headers, HttpStatus.OK);
//	}
	
	private String apiCall(String numOfRows) throws IOException{
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=��������Ű"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml �Ǵ� json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*�� ������ ��� ��*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*��������ȣ*/
        urlBuilder.append("&" + URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode("2020", "UTF-8")); /*���� ����*/
        urlBuilder.append("&" + URLEncoder.encode("itemCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*�̼����� �׸� ����(PM10, PM25), PM10/PM25 ��� ��ȸ�� ��� �Ķ���� ����*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            System.out.println(conn.getInputStream());
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
