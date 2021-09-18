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
		System.out.println("1.남자중학교 2.여자중학교 3.남자공업고등학교 4.여자상업고등학교");
		int bunho = scanner.nextInt();
		return bunho;
	}
	
	private static void inputManSchool() {
		ManSchool manshool = new ManSchool();
		System.out.print("국어 : ");
		manshool.setKor(scanner.nextInt());
		System.out.print("영어 : ");
		manshool.setEng(scanner.nextInt());
		System.out.print("수학 : ");
		manshool.setMath(scanner.nextInt());
		System.out.print("기술 : ");
		manshool.setGis(scanner.nextInt());
		System.out.println(manshool.manInfo());
	}
	
	private static void inputWomanSchool() {
		WomanSchool womanshool = new WomanSchool();
		System.out.print("국어 : ");
		womanshool.setKor(scanner.nextInt());
		System.out.print("영어 : ");
		womanshool.setEng(scanner.nextInt());
		System.out.print("수학 : ");
		womanshool.setMath(scanner.nextInt());
		System.out.print("가정 : ");
		womanshool.setGajong(scanner.nextInt());
		System.out.println(womanshool.womanInfo());
	}
	
	private static void inputManGongupSchool() {
		ManGongupSchool mansgongupschool = new ManGongupSchool();
		System.out.print("국어 : ");
		mansgongupschool.setKor(scanner.nextInt());
		System.out.print("영어 : ");
		mansgongupschool.setEng(scanner.nextInt());
		System.out.print("수학 : ");
		mansgongupschool.setMath(scanner.nextInt());
		System.out.print("기술 : ");
		mansgongupschool.setGis(scanner.nextInt());
		System.out.print("공업 : ");
		mansgongupschool.setGongup(scanner.nextInt());
		System.out.println(mansgongupschool.manGongupInfo());
	}
	
	private static void inputWomanSangupSchool() {
		WomanSangupSchool womansangupshool = new WomanSangupSchool();
		System.out.print("국어 : ");
		womansangupshool.setKor(scanner.nextInt());
		System.out.print("영어 : ");
		womansangupshool.setEng(scanner.nextInt());
		System.out.print("수학 : ");
		womansangupshool.setMath(scanner.nextInt());
		System.out.print("가정 : ");
		womansangupshool.setGajong(scanner.nextInt());
		System.out.print("상업 : ");
		womansangupshool.setSangup(scanner.nextInt());
		System.out.println(womansangupshool.womanSangupInfo());
	}

}
