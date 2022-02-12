package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Run {
	public static void main(String[] args) throws IOException {
		// 서버가 실행되어 있다면 내가 만들어둔 스프링 프로젝트에서도 웹 정보 가져오기가 가능
		StringBuilder urlBuilder = new StringBuilder("http://127.0.0.1:8094/app26/"); /* 만들어둔 spring26 project URL 링크, 서버 실행상태 */
        
        URL url = new URL(urlBuilder.toString());
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        conn.setRequestMethod("GET");
       
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
//      	sb.append(line);
        	System.out.println(line);
        	
        	if(line.contains("real-time")) {
        		System.out.println(line.substring(23,28));
        	}
        }
        
        rd.close();
        conn.disconnect();
        
//        System.out.println(sb.toString());
        
	}
}
