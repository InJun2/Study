package Test;

import java.util.Scanner;

public class Professor {
	private String name;
	private int age;
	private String subject;
	
	private Scanner sc = new Scanner(System.in);
	
	public void setInfo() {
		System.out.printf("���� :");
		this.age = sc.nextInt();
		System.out.printf("�̸� :");
		this.name = sc.next();
		System.out.printf("���� :");
		this.subject = sc.next();
	}
	
	public String getName() {
		return name;
	}
	
	public void getInfo() {
		System.out.println("���� : "+age+ "\t �̸�: "+ name +"\t ����: "+subject);
	}
	
}
