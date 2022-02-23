package main.thread.join;

public class MyThread  extends Thread{
	
	public int num = 0;
	
	@Override
	public void run() {
		System.out.println("MyThread");
		
		for(int i = 0 ; i <1000; ++i) {
			num += 1;
		}
		
		System.out.println("num : " + num);
	}
}
