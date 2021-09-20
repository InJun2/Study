package Test;

import java.util.Scanner;

public class Manager {
	private String name;
	private int age;
	private String Department;
	
	private Scanner sc = new Scanner(System.in);
	
	public void setInfo() {
		System.out.printf("나이 :");
		this.age = sc.nextInt();
		System.out.printf("이름 :");
		this.name = sc.next();
		System.out.printf("부서:");
		this.Department = sc.next();
	}
	
	public String getName() {
		return name;
	}
	
	public void getInfo() {
		System.out.println("나이 : "+age+ "\t 이름: "+ name +"\t 부서: "+Department);
	}
	
	
}
