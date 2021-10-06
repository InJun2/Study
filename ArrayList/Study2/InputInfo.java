package Test2;

import java.util.Scanner;

public class InputInfo {
	
	private final Scanner scanner = new Scanner(System.in);
	
	InputInfo(){
		String name = InputName();
		String tel = InputTel();
		String email = InputEmail();
		Customer customer = new Customer(name,tel,email);
		new CustomerList(customer);
	}
	
	
	public String InputName() {
		System.out.print("소비자의 이름 :");
		return scanner.next();
	}
	public String InputTel() {
		System.out.print("소비자의 전화번호 :");
		return scanner.next();
	}
	public String InputEmail() {
		System.out.print("소비자의 Eamil :");
		return scanner.next();
	}
	
}
