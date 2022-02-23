package main.thread;


public class ThreadCreate {
	public static void main(String[] args) {
		
		// 쓰레드 생성
		
		// 방법 1 : 인터페이스 Runnable 객체 생성하여 메소드 오버라이딩
		Runnable r = new Runnable() {	// Runnable은 interface 형식
			@Override
			public void run() {			// Runnable 필요 메소드 오버라이딩
				System.out.println("my Thread");
			}
		};
		
		Thread t = new Thread(r);		// 온전한 쓰레드 생성
		t.start(); 						// 쓰레드 실행
		
		
		// ---------------------------------------------------------------------
		
		// 방법 2 : 람다식 이용
		Thread t2 = new Thread(() -> {
			System.out.println("my Thread2");
		});
		
		t2.start();
		
		
	}
}
