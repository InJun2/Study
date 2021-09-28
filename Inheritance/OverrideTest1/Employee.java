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
		System.out.println("�ڽĸ޼ҵ� Employee()");
	}	// �������̵��Ͽ� �������ؾ� ��ĳ������ ��ü���� Employee �� personDisp() �޼ҵ� ����

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
