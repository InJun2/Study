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
			serverSocket = new ServerSocket(5000); // 1~1000 포트는 쓰면안됨 
			while(true) {
				System.out.println("요청대기 : ");
				socket = serverSocket.accept(); // 요청대기
				System.out.println("접속한 클라이언트 :" + socket.getInetAddress()); // 클라이언트 고정 IP받아옴
				is = socket.getInputStream();	
				os = socket.getOutputStream();
				ois = new ObjectInputStream(is);
				oos = new ObjectOutputStream(os);
				String msg = (String) ois.readObject();
				System.out.println("클라이언트에서 보낸메세지 : " + msg);
				String retMsg = "서버로부터 되돌아온 메세지 :" + msg;
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
		new TCPServer().start(); // 상속, Thread 안에 start시 run 작동, stop 작동
	}
}
