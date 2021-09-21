package Test;

import java.util.List;
import java.util.Scanner;

public class FindArrayList {

	private final Scanner scanner = new Scanner(System.in);

	FindArrayList(Person per) {
		findSelect(per);

	}

	private void findSelect(Person per) {
		boolean searchresult = false;
		System.out.println("찾을 사람의 유형을 선택해주세요 1.학생 2.교수 3.관리자");
		int num = scanner.nextInt();
		System.out.println("찾을 이름을 입력해주세요");
		String name = scanner.next();
		if (num == 1) {
			searchresult = findStudent(per, name);
		}
		if (num == 2) {
			searchresult = findProfessor(per, name);
		}
		if (num == 3) {
			searchresult = findManager(per, name);
		}
		if (num == 4) {
			return;
		}
		if (!searchresult) {
			System.out.println("검색에 실패하였습니다");
		}
	}

	private boolean findStudent(Person per, String name) {
		List<Student> student = per.getStu();
		for (int i = 0; i < student.size(); i++) {
			if (name.equals(student.get(i).getName())) {
				per.studentInfo((Student) per.getStu().get(i));
				return true;
			}
		}
		return false;
	}

	private boolean findProfessor(Person per, String name) {
		List<Professor> professor = per.getPro();
		for (int i = 0; i < professor.size(); i++) {
			if (name.equals(professor.get(i).getName())) {
				per.professorInfo((Professor) per.getPro().get(i));
				return true;
			}
		}
		return false;
	}

	private boolean findManager(Person per, String name) {
		List<Manager> manager = per.getMan();
		for (int i = 0; i < manager.size(); i++) {
			if (name.equals(manager.get(i).getName())) {
				per.managerInfo((Manager) per.getMan().get(i));
				return true;
			}
		}
		return false;
	}

}
