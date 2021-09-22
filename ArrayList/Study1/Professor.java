package Test;

import java.util.Scanner;

public class Professor {
	private String name;
	private int age;
	private String subject;
	
	private Scanner sc = new Scanner(System.in);
	
	public void setInfo() {
		System.out.printf("나이 :");
		this.age = sc.nextInt();
		System.out.printf("이름 :");
		this.name = sc.next();
		System.out.printf("과목 :");
		this.subject = sc.next();
	}
	
	public String getName() {
		return name;
	}
	
	public void getInfo() {
		System.out.println("*교수 정보* \n나이 : "+age+ "   이름: "+ name +"   과목: "+subject);
	}
	
}
