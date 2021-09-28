package kr.or.kh05;

public class Student extends Person {
	private String schoolKind;
	private String grade;

	public Student() {
		this("no-school","no-grade");
	}
	
	public Student(String schoolkind, String grade) {
		this.schoolKind =schoolkind;
		this.grade = grade;
	}

	@Override
	public void personDisp() {
		System.out.println("자식메소드 Stduent()");
	}

	public String getSchoolKind() {
		return schoolKind;
	}

	public void setSchoolKind(String schoolKind) {
		this.schoolKind = schoolKind;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
}
