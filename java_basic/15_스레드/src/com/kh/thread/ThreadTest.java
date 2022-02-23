package main.thread;

public class ThreadTest {
	
	public static void main(String[] args) {
		
		Thread t = Thread.currentThread();	// 현재 쓰레드 가져오기
		
		t.setName("ij");		//  이름 설정
		t.setPriority(0);		// 우선 순위 설정 1~10, 숫자가 높을 수록 우선순위가 높다 ( 기본값 5 )
								// or Thread.MAX_PRIORITY, Thread.MIN_PRIORITY, Thread.NOMAL_PRIORITY 
		
		String name = t.getName();
		long id = t.getId();
		int priorirty = t.getPriority();
		
		System.out.println("name : "+name);
		System.out.println("id : " +id);
		System.out.println("priority : "+priorirty);
		
		
		
	}
	
}
