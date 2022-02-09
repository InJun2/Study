package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main3 {
	public static void main(String[] args) throws Exception {
String key = "�������������п��� �޾ƿ� ������ ����Ű";
		
		// URL ����
		StringBuilder url = new StringBuilder("http://apis.data.go.kr/6260000/PublicArt/getPublicArtInfo");
		url .append( "?" + "serviceKey=" + key); // �ʼ�
		url .append( "&" + "returnType=xml");
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
		System.out.println(result);
	}
}
