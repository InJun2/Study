package kr.or.kh02;

import java.util.Scanner;

public class SchoolTest {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			int bunho = selectSchool();
			if (bunho == 1) {
				ManSchool manschool = new ManSchool();
				ManSchool.inputManSchool(manschool);
				System.out.println(manschool.manInfo());
			}
			if (bunho == 2) {
				WomanSchool womanschool = new WomanSchool();
				WomanSchool.inputWomanSchool(womanschool);
				System.out.println(womanschool.womanInfo());
			}
			if (bunho == 3) {
				ManGongupSchool mansgongupschool = new ManGongupSchool();
				ManGongupSchool.inputManGongupSchool(mansgongupschool);
				System.out.println(mansgongupschool.manGongupInfo());
			}
			if (bunho == 4) {
				WomanSangupSchool womansangupschool = new WomanSangupSchool();
				WomanSangupSchool.inputWomanSangupSchool(womansangupschool);
				System.out.println(womansangupschool.womanSangupInfo());
			}

		}

	}

	private static int selectSchool() {
		System.out.println("1.남자중학교 2.여자중학교 3.남자공업고등학교 4.여자상업고등학교");
		int bunho = scanner.nextInt();
		return bunho;
	}
}
