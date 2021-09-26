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
		System.out.print("�Һ����� �̸� :");
		return scanner.next();
	}
	public static String InputTel() {
		System.out.print("�Һ����� ��ȭ��ȣ :");
		return scanner.next();
	}
	public static String InputEmail() {
		System.out.print("�Һ����� Eamil :");
		return scanner.next();
	}
	
}
