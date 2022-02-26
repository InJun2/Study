package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) throws IOException {
		System.out.println("ccc");

//		1. 서버의 포트 번호 정하기	// 12345
//		2. 서버용 소켓 객체 생성
		ServerSocket serverSocket = new ServerSocket(12345);
		System.out.println("클라이언트 연결 대기 중");
//		3. 클라이언트 쪽에서 접속 요청이 오길 기다림
//		4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
		Socket socket = serverSocket.accept();
//		5. 연결된 클라이언트와 입출력 스트림 생성
//		6. 보조 스트림을 통해 성능 개선
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		
//		7. 스트림을 통해 읽고 쓰기
		writer.println("connected");	// 보내기
		writer.flush();
		
		String msg = reader.readLine();	// 읽음
		System.out.println(msg);
		
//		8. 통신 종료, 자원 반납
		reader.close();
		writer.close();
		socket.close();
		
		serverSocket.close();
	}
}
