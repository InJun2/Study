package kr.or.kh05;

public class Person {
	protected int age;
	protected String name;
	protected String addr;
	
	public Person() {
		this(0,"no-name","no-addr");
	}
	
	public Person(int age, String name, String addr) {
		this.age=age;
		this.name=name;
		this.addr=addr;
	}
	
	public void personDisp() {
		System.out.println("부모클래스 Person()");
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
