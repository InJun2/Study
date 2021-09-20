package Test;

import java.util.HashMap;
import java.util.Scanner;

public class Registration {
	static final Scanner sc = new Scanner(System.in);
	
	Registration(Person per) {		
		View.RegistrationView();
		int select2 = sc.nextInt();
		if (select2 == 1) {
			setStudent(per);
		} if (select2 == 2) {
			setProfessor(per);
		} if (select2 == 3) {
			setManager(per);
		} if (select2 == 4) {
			return;
		} else {
			RuntimeException("잘못된 번호입니다");
		}
		
	}
	
	private void setStudent(Person per) {
		Student stu = new Student();
		stu.setInfo();
		per.setStu(stu);
	}
	
	private void setProfessor(Person per) {
		Professor pro = new Professor();
		pro.setInfo();
		per.setPro(pro);
	}
	
	private void setManager(Person per) {
		Manager man = new Manager();
		man.setInfo();
		per.setMan(man);
	}
	
	private void RuntimeException(String str) {
		throw new RuntimeException(str);
	}
}
