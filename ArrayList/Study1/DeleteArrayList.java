package Test;

import java.util.List;
import java.util.Scanner;

public class DeleteArrayList {

	private Scanner scanner = new Scanner(System.in);
	
	public DeleteArrayList(Person per) {
		findDelete(per);
	}
	
	private void findDelete(Person per) {
		boolean deleteresult = false;
		System.out.println("삭제할 사람의 유형을 선택해주세요 1.학생 2.교수 3.관리자");
		int num = scanner.nextInt();
		System.out.println("삭제할 사람의 이름을 입력해주세요");
		String name = scanner.next();
		if (num == 1) {
			deleteresult = deleteStudent(per, name);
		}
		if (num == 2) {
			deleteresult = deleteProfessor(per, name);
		}
		if (num == 3) {
			deleteresult = deleteManager(per, name);
		}
		if (num == 4) {
			return;
		}
		if (!deleteresult) {
			System.out.println("삭제할 인원의 이름 검색에 실패하였습니다");
		}
	}

	private boolean deleteStudent(Person per, String name) {
		List<Student> student = per.getStu();
		for (int i = 0; i < student.size(); i++) {
			if (name.equals(student.get(i).getName())) {
				System.out.println(name +"님의 정보를 삭제하였습니다");
				per.getStu().remove(i);
				return true;
			}
		}
		return false;
	}

	private boolean deleteProfessor(Person per, String name) {
		List<Professor> professor = per.getPro();
		for (int i = 0; i < professor.size(); i++) {
			if (name.equals(professor.get(i).getName())) {
				System.out.println(name +"님의 정보를 삭제하였습니다");
				per.getPro().remove(i);
				return true;
			}
		}
		return false;
	}

	private boolean deleteManager(Person per, String name) {
		List<Manager> manager = per.getMan();
		for (int i = 0; i < manager.size(); i++) {
			if (name.equals(manager.get(i).getName())) {
				System.out.println(name +"님의 정보를 삭제하였습니다");
				per.getMan().remove(i);
				return true;
			}
		}
		return false;
	}
}
