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

//		1. ������ ��Ʈ ��ȣ ���ϱ�	// 12345
//		2. ������ ���� ��ü ����
		ServerSocket serverSocket = new ServerSocket(12345);
		System.out.println("Ŭ���̾�Ʈ ���� ��� ��");
//		3. Ŭ���̾�Ʈ �ʿ��� ���� ��û�� ���� ��ٸ�
//		4. ���� ��û�� ���� ��û ���� �� �ش� Ŭ���̾�Ʈ�� ���� ���� ��ü ����
		Socket socket = serverSocket.accept();
//		5. ����� Ŭ���̾�Ʈ�� ����� ��Ʈ�� ����
//		6. ���� ��Ʈ���� ���� ���� ����
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		
//		7. ��Ʈ���� ���� �а� ����
		writer.println("connected");	// ������
		writer.flush();
		
		String msg = reader.readLine();	// ����
		System.out.println(msg);
		
//		8. ��� ����, �ڿ� �ݳ�
		reader.close();
		writer.close();
		socket.close();
		
		serverSocket.close();
	}
}
