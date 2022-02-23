package main.thread;


public class ThreadCreate {
	public static void main(String[] args) {
		
		// ������ ����
		
		// ��� 1 : �������̽� Runnable ��ü �����Ͽ� �޼ҵ� �������̵�
		Runnable r = new Runnable() {	// Runnable�� interface ����
			@Override
			public void run() {			// Runnable �ʿ� �޼ҵ� �������̵�
				System.out.println("my Thread");
			}
		};
		
		Thread t = new Thread(r);		// ������ ������ ����
		t.start(); 						// ������ ����
		
		
		// ---------------------------------------------------------------------
		
		// ��� 2 : ���ٽ� �̿�
		Thread t2 = new Thread(() -> {
			System.out.println("my Thread2");
		});
		
		t2.start();
		
		
	}
}
