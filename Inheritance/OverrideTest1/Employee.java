package kr.or.kh05;

public class Employee extends Person {
	private String department;
	
	public Employee() {
		this("no-department");
	}

	public Employee(String department) {
		this.department =department;
	}

	@Override
	public void personDisp() {
		System.out.println("자식메소드 Employee()");
	}	// 오버라이딩하여 재정의해야 업캐스팅한 객체에서 Employee 의 personDisp() 메소드 실행

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
