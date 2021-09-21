package Test;

import java.util.Scanner;

public class MainTest {
	private static final Scanner sc = new Scanner(System.in);
	
	public static Person per = new Person();

	public static void main(String[] args) {
		while(true) {
		View.ViewInfo();
		int select1 = sc.nextInt();
		select(select1);
		
		}
	}

	private static void select(int select1) {
		if (select1 == 1) {
			new Registration(per);
		}
		else if (select1 == 2) {
			new FindArrayList(per);
		}
	}

}
