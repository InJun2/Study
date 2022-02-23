package main.thread.synchroniz;

public class ThreadMonitor {

	public static void main(String[] args) {
		
		// ����� ��ü ����
		Worker worker = new Worker();
		
		// ������ 2�� ����
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					// 1�ʸ��� Worker�� A ȣ��
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
				// 1�ʸ��� Worker�� B ȣ��
					try {
						Thread.sleep(1000);
						worker.methodB();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		// ���� �޼ҵ� a,b ��� ȣ��
		t1.start();
		t2.start();
		
		// �ڹٴ� ������ �����ٸ��� �Ұ���
		// ������ ������� : ������ ���� -> ������ -> ���� ( -> �Ͻ����� -> ������� ���ư��� ) -> ������ �Ҹ�
		// ������ ��Ʈ�� : �������� �������� ���¸� �����ϱ� ���� ��
		// �Ͻ������� ���� : sleep(), join(), wait(), I/O block
		// ������� ���� : interrupt(), notify(), notifyAll()
		
		// �������� ���� : new, runnable, wait, terminated
		
	}

}
