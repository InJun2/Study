package Test;

import java.util.Scanner;

public class Student {
	private String name;
	private int age;
	private int number;
	
	private Scanner sc = new Scanner(System.in);
	
	public void setInfo() {
		System.out.printf("나이 :");
		this.age = sc.nextInt();
		System.out.printf("이름 :");
		this.name = sc.next();
		System.out.printf("학번 :");
		this.number = sc.nextInt();
	}
	
	public String getName() {
		return name;
	}
	
	public void getInfo() {
		System.out.println("*학생 정보* \n나이 : "+age+ "   이름: "+ name +"   학번: "+number);
	}
	
	
}
