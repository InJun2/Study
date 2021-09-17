package kr.or.test5;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends Thread {
	private InputStream is;
	private OutputStream os;
	private ServerSocket serverSocket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket;
	
	
	public void run() {
		try {
			serverSocket = new ServerSocket(5000); // 1~1000 ��Ʈ�� ����ȵ� 
			while(true) {
				System.out.println("��û��� : ");
				socket = serverSocket.accept(); // ��û���
				System.out.println("������ Ŭ���̾�Ʈ :" + socket.getInetAddress()); // Ŭ���̾�Ʈ ���� IP�޾ƿ�
				is = socket.getInputStream();	
				os = socket.getOutputStream();
				ois = new ObjectInputStream(is);
				oos = new ObjectOutputStream(os);
				String msg = (String) ois.readObject();
				System.out.println("Ŭ���̾�Ʈ���� �����޼��� : " + msg);
				String retMsg = "�����κ��� �ǵ��ƿ� �޼��� :" + msg;
				oos.writeObject(retMsg);
				socket.close();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
	}
	
	public static void main(String[] args) {
		new TCPServer().start(); // ���, Thread �ȿ� start�� run �۵�, stop �۵�
	}
}
