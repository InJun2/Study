package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Run {
	public static void main(String[] args) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://127.0.0.1:8094/app26/"); /* spring으로 만든 project URL ( 서버실행 됨 ) */
        
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
