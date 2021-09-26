package Test2;

import java.util.Scanner;

public class InputInfo {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	InputInfo(){
		String name = InputInfo.InputName();
		String tel = InputInfo.InputTel();
		String email = InputInfo.InputEmail();
		Customer customer = new Customer(name,tel,email);
		new CustomerList(customer);
	}
	
	
	public static String InputName() {
		System.out.print("소비자의 이름 :");
		return scanner.next();
	}
	public static String InputTel() {
		System.out.print("소비자의 전화번호 :");
		return scanner.next();
	}
	public static String InputEmail() {
		System.out.print("소비자의 Eamil :");
		return scanner.next();
	}
	
}
