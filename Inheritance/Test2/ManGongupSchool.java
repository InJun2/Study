package kr.or.kh02;

import java.util.Scanner;

public class ManGongupSchool extends ManSchool {
	private int gongup;

	public String manGongupInfo() {
		return "국어 : " + getKor() + "영어 : " + getEng() + "수학 : " + getMath() + " 기술: " + getGis()+" 공업: " + getGongup();
	}
	
	public int getGongup() {
		return gongup;
	}

	public void setGongup(int gongup) {
		this.gongup = gongup;
	}
	
	protected static void inputManGongupSchool(Scanner scanner) {
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
	
}
