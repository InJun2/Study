package main.thread.synchroniz;

public class ThreadMonitor {

	public static void main(String[] args) {
		
		// 사용할 객체 생성
		Worker worker = new Worker();
		
		// 스레드 2개 생성
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					// 1초마다 Worker의 A 호출
					try {
						Thread.sleep(1000);
						worker.methodA();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
				// 1초마다 Worker의 B 호출
					try {
						Thread.sleep(1000);
						worker.methodB();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		// 각각 메소드 a,b 계속 호출
		t1.start();
		t2.start();
		
		// 자바는 스레드 스케줄링이 불가능
		// 스레드 실행순서 : 스레드 생성 -> 실행대기 -> 실행 ( -> 일시정지 -> 실행대기로 돌아가기 ) -> 스레드 소멸
		// 스레드 컨트롤 : 실행중인 스레드의 상태를 제어하기 위한 것
		// 일시정지로 변경 : sleep(), join(), wait(), I/O block
		// 실행대기로 변경 : interrupt(), notify(), notifyAll()
		
		// 스레드의 상태 : new, runnable, wait, terminated
		
	}

}
