package kr.or.kh05;

public class President extends Person {
	private int salary;
	private String nation;
	
	public President() {
		this(0,"no-nation");
	}

	public President(int salary, String nation) {
		this.salary = salary;
		this.nation = nation;
	}

	@Override
	public void personDisp() {
		System.out.println("자식메소드 President()");
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	
	
	
}
