package Test;

import java.util.ArrayList;

public class Person {	

	private ArrayList<Student> stu;
	private ArrayList<Manager> man;
	private ArrayList<Professor> pro;
	
	public ArrayList getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu.add(stu);
	}
	public ArrayList getMan() {
		return man;
	}
	public void setMan(Manager man) {
		this.man.add(man);
	}
	public ArrayList getPro() {
		return pro;
	}
	public void setPro(Professor pro) {
		this.pro.add(pro);
	}
	
	
	

}
