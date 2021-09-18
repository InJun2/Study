package kr.or.kh02;

import java.util.Scanner;

public class SchoolTest {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			int bunho = selectSchool();
			if(bunho==1) {
				inputManSchool();
			}
			if(bunho==2) {
				inputWomanSchool();
			}
			if(bunho==3) {
				inputManGongupSchool();
			}
			if(bunho==4) {
				inputWomanSangupSchool();
			}
			
		}
		
	}
	
	private static int selectSchool() {
		System.out.println("1.�������б� 2.�������б� 3.���ڰ�������б� 4.���ڻ������б�");
		int bunho = scanner.nextInt();
		return bunho;
	}
	
	private static void inputManSchool() {
		ManSchool manshool = new ManSchool();
		System.out.print("���� : ");
		manshool.setKor(scanner.nextInt());
		System.out.print("���� : ");
		manshool.setEng(scanner.nextInt());
		System.out.print("���� : ");
		manshool.setMath(scanner.nextInt());
		System.out.print("��� : ");
		manshool.setGis(scanner.nextInt());
		System.out.println(manshool.manInfo());
	}
	
	private static void inputWomanSchool() {
		WomanSchool womanshool = new WomanSchool();
		System.out.print("���� : ");
		womanshool.setKor(scanner.nextInt());
		System.out.print("���� : ");
		womanshool.setEng(scanner.nextInt());
		System.out.print("���� : ");
		womanshool.setMath(scanner.nextInt());
		System.out.print("���� : ");
		womanshool.setGajong(scanner.nextInt());
		System.out.println(womanshool.womanInfo());
	}
	
	private static void inputManGongupSchool() {
		ManGongupSchool mansgongupschool = new ManGongupSchool();
		System.out.print("���� : ");
		mansgongupschool.setKor(scanner.nextInt());
		System.out.print("���� : ");
		mansgongupschool.setEng(scanner.nextInt());
		System.out.print("���� : ");
		mansgongupschool.setMath(scanner.nextInt());
		System.out.print("��� : ");
		mansgongupschool.setGis(scanner.nextInt());
		System.out.print("���� : ");
		mansgongupschool.setGongup(scanner.nextInt());
		System.out.println(mansgongupschool.manGongupInfo());
	}
	
	private static void inputWomanSangupSchool() {
		WomanSangupSchool womansangupshool = new WomanSangupSchool();
		System.out.print("���� : ");
		womansangupshool.setKor(scanner.nextInt());
		System.out.print("���� : ");
		womansangupshool.setEng(scanner.nextInt());
		System.out.print("���� : ");
		womansangupshool.setMath(scanner.nextInt());
		System.out.print("���� : ");
		womansangupshool.setGajong(scanner.nextInt());
		System.out.print("��� : ");
		womansangupshool.setSangup(scanner.nextInt());
		System.out.println(womansangupshool.womanSangupInfo());
	}

}
