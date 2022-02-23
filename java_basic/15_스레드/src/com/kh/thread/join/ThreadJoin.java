package main.thread.join;

public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {
		// ������ start : ���� ó��
		System.out.println("������ ���� // start");
		
		Thread t = new MyThread();
		t.start();
		t.join();		// join�� �ش� �����尡 ���ᰡ �Ǳ���� ��ٷȴٰ� �Ѿ, join�� ������ run ���� ������ �����
		
		System.out.println("������ ���� // start");
		
		// ������ run : ���� �޼ҵ� �������� �׿� ���� ó�� �Ұ���
		System.out.println("������ ���� // run");
		
		Thread t2 = new MyThread();
		t2.run();
		
		System.out.println("������ ���� // run");
		
	}

}
