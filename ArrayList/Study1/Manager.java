package Test;

import java.util.Scanner;

public class Manager {
	private String name;
	private int age;
	private String Department;
	
	private Scanner sc = new Scanner(System.in);
	
	public void setInfo() {
		System.out.printf("���� :");
		this.age = sc.nextInt();
		System.out.printf("�̸� :");
		this.name = sc.next();
		System.out.printf("�μ�:");
		this.Department = sc.next();
	}
	
	public String getName() {
		return name;
	}
	
	public void getInfo() {
		System.out.println("���� : "+age+ "\t �̸�: "+ name +"\t �μ�: "+Department);
	}
	
	
}
