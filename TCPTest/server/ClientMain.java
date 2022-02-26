package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {
	public static void main(String[] args) throws UnknownHostException, IOException {
//		1. 서버의 IP 주소와 서버가 정한 포트 번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
		Socket socket = new Socket("127.0.0.1", 12345);

//		2. 서버와의 입출력 스트림 오픈
//		3. 보조 스트림을 통해 성능 개선
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		
//		4. 스트림을 통해 읽고 쓰기
		String msg = reader.readLine();
		System.out.println(msg);
		
		writer.println("클라이언트");
		
//		5. 통신 종료
		reader.close();
		writer.close();
		socket.close();
		
	}

}
