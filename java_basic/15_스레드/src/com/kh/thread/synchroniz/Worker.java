package main.thread.synchroniz;

public class Worker {
	
	public synchronized void methodA(){		// synchronized : 한개의 스레드만 실행 가능, 다른 스레드가 접근이 안됨 ( 동기화 처리 )
		System.out.println("aaa");
		notify();	// 객체 안에서 wait 상태인 쓰레드를 다시 동작 시킴
		try {
			wait();		// 스레드 상태 wait로 변경, synchronized 접근 제한 중지,  다른 스레드가 진입이 가능하게됨
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public synchronized void methodB() {
		System.out.println("bbb");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
}
