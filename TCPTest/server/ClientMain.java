package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {
	public static void main(String[] args) throws UnknownHostException, IOException {
//		1. ������ IP �ּҿ� ������ ���� ��Ʈ ��ȣ�� �Ű������� �Ͽ� Ŭ���̾�Ʈ�� ���� ��ü ����
		Socket socket = new Socket("127.0.0.1", 12345);

//		2. �������� ����� ��Ʈ�� ����
//		3. ���� ��Ʈ���� ���� ���� ����
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		
//		4. ��Ʈ���� ���� �а� ����
		String msg = reader.readLine();
		System.out.println(msg);
		
		writer.println("Ŭ���̾�Ʈ");
		
//		5. ��� ����
		reader.close();
		writer.close();
		socket.close();
		
	}

}
