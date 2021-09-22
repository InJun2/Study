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
		System.out.println("������ ����� ������ �������ּ��� 1.�л� 2.���� 3.������");
		int num = scanner.nextInt();
		System.out.println("������ ����� �̸��� �Է����ּ���");
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
			System.out.println("������ �ο��� �̸� �˻��� �����Ͽ����ϴ�");
		}
	}

	private boolean deleteStudent(Person per, String name) {
		List<Student> student = per.getStu();
		for (int i = 0; i < student.size(); i++) {
			if (name.equals(student.get(i).getName())) {
				System.out.println(name +"���� ������ �����Ͽ����ϴ�");
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
				System.out.println(name +"���� ������ �����Ͽ����ϴ�");
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
				System.out.println(name +"���� ������ �����Ͽ����ϴ�");
				per.getMan().remove(i);
				return true;
			}
		}
		return false;
	}
}
