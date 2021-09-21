package Test;

import java.util.ArrayList;

public class Person {	
	private ArrayList<Student> students = new ArrayList<>();
	private ArrayList<Manager> managers = new ArrayList<>();
	private ArrayList<Professor> professors = new ArrayList<>();
	
	Person(){
		
	}
	
	public ArrayList<Student> getStu() {
		return students;
	}
	public void setStu(Student stu) {
		students.add(stu);
	}
	public ArrayList<Manager> getMan() {
		return managers;
	}
	public void setMan(Manager man) {
		managers.add(man);
	}
	public ArrayList<Professor> getPro() {
		return professors;
	}
	public void setPro(Professor pro) {
		professors.add(pro);
	}
	
	public void studentInfo(Student stu) {
		stu.getInfo();
	}
	public void professorInfo(Professor pro) {
		pro.getInfo();
	}
	public void managerInfo(Manager man) {
		man.getInfo();
	}
	
	
	

}
