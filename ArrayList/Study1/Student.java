package Test;

import java.util.Scanner;

public class Student {
	private String name;
	private int age;
	private int number;
	
	private Scanner sc = new Scanner(System.in);
	
	public void setInfo() {
		System.out.printf("���� :");
		this.age = sc.nextInt();
		System.out.printf("�̸� :");
		this.name = sc.next();
		System.out.printf("�й� :");
		this.number = sc.nextInt();
	}
	
	public String getName() {
		return name;
	}
	
	public void getInfo() {
		System.out.println("���� : "+age+ "\t �̸�: "+ name +"\t �й�: "+number);
	}
	
	
}
