package main.thread.join;

public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {
		// 스레드 start : 병행 처리
		System.out.println("스레드 시작 // start");
		
		Thread t = new MyThread();
		t.start();
		t.join();		// join은 해당 스레드가 종료가 되기까지 기다렸다가 넘어감, join이 없을시 run 먼저 스레드 실행됨
		
		System.out.println("스레드 종료 // start");
		
		// 스레드 run : 메인 메소드 위쪽으로 쌓여 병행 처리 불가능
		System.out.println("스레드 시작 // run");
		
		Thread t2 = new MyThread();
		t2.run();
		
		System.out.println("스레드 종료 // run");
		
	}

}
