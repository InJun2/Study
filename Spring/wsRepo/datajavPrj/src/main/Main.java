package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Main {
	// String vs StringBuilder vs StringBuffer 
	// String : ���ڿ��� ������ ���� ���
	// StringBuilder : ���ڿ��� ������ ���� ���, ����ȭ�� ���� X ( ���Ͼ����� ������ StringBuffer ���� ���� )
	// StringBuffer : ���ڿ��� ������ ���� ���, ����ȭ�� ���� O ( ��Ƽ������ ȯ�濡�� ������ )
	
	public static void main(String[] args) throws Exception {
		
//		1. URL ���� ( ��û�ּ� + �Ķ���͵� ����, �׸��ҿ� �ʼ��� �ɼ��� ����, �ʼ��� �ۼ��ص� ��� ���� )
//		2. URL ��ü ���� ( 1���� ���� URL �̿��ؼ� )
//		3. URL�� �̿��ؼ� Ŀ�ؼ� ��������
//		4. request�� ��û��� (method), header ����
//		5. Ŀ�ؼǿ��� inputStream ������ ( BufferedReader�� ��ȯ )
//		6. 5���� ������ ��Ʈ������ ������ ���پ� �б� ( ������Ű�� ) 
//		7. ����� �ڿ��� ( BufferedReader, HttpURLConnection ) ���� �ϱ� ( �ڿ� �ݳ� )
//		8. ������ String Ȯ��

		String key = "�������������п��� �޾ƿ� ������ ����Ű";
		
		// URL ����
		StringBuilder url = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo");
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
