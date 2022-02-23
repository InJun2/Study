package main.thread.synchroniz;

public class Worker {
	
	public synchronized void methodA(){		// synchronized : �Ѱ��� �����常 ���� ����, �ٸ� �����尡 ������ �ȵ� ( ����ȭ ó�� )
		System.out.println("aaa");
		notify();	// ��ü �ȿ��� wait ������ �����带 �ٽ� ���� ��Ŵ
		try {
			wait();		// ������ ���� wait�� ����, synchronized ���� ���� ����,  �ٸ� �����尡 ������ �����ϰԵ�
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
