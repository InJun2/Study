package Test;


import java.util.Scanner;

public class Registration {
	static final Scanner sc = new Scanner(System.in);
	
	Registration(Person per) {		
		View.RegistrationView();
		int select = sc.nextInt();
		boolean selectNum = false;
		if (select == 1) {
			selectNum = setStudent(per);
		} if (select == 2) {
			selectNum = setProfessor(per);
		} if (select == 3) {
			selectNum = setManager(per);
		} if (select == 4) {
			return;
		} if(!selectNum) {
			RuntimeException("잘못된 번호입니다");
		}
		
	}
	
	private boolean setStudent(Person per) {
		Student stu = new Student();
		stu.setInfo();
		per.setStu(stu);
		return true;
	}
	
	private boolean setProfessor(Person per) {
		Professor pro = new Professor();
		pro.setInfo();
		per.setPro(pro);
		return true;
	}
	
	private boolean setManager(Person per) {
		Manager man = new Manager();
		man.setInfo();
		per.setMan(man);
		return true;
	}
	
	private void RuntimeException(String str) {
		throw new RuntimeException(str);
	}
}
