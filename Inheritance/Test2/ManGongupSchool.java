package kr.or.kh02;

import java.util.Scanner;

public class ManGongupSchool extends ManSchool {
	private static final Scanner scanner = new Scanner(System.in);
	private int gongup;

	public String manGongupInfo() {
		return "국어 : " + getKor() + " 영어 : " + getEng() + " 수학 : " + getMath() + " 기술: " + getGis()+" 공업: " + getGongup()
		+ " 총점 : " + total() + " 평균 : " + avg();
	}
	
	public int getGongup() {
		return gongup;
	}

	public void setGongup(int gongup) {
		this.gongup = gongup;
	}
	
	public int total() {
		return super.total()+gongup;
	}

	public double avg() {
		return total()/5.0;
	}
	
	protected static void inputManGongupSchool(ManGongupSchool mansgongupschool) {
		inputManSchool(mansgongupschool);
		System.out.print("공업 : ");
		mansgongupschool.setGongup(scanner.nextInt());
	}
	
}
