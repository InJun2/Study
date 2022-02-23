package main.thread;

public class ThreadTest {
	
	public static void main(String[] args) {
		
		Thread t = Thread.currentThread();	// ���� ������ ��������
		
		t.setName("ij");		//  �̸� ����
		t.setPriority(0);		// �켱 ���� ���� 1~10, ���ڰ� ���� ���� �켱������ ���� ( �⺻�� 5 )
								// or Thread.MAX_PRIORITY, Thread.MIN_PRIORITY, Thread.NOMAL_PRIORITY 
		
		String name = t.getName();
		long id = t.getId();
		int priorirty = t.getPriority();
		
		System.out.println("name : "+name);
		System.out.println("id : " +id);
		System.out.println("priority : "+priorirty);
		
		
		
	}
	
}
