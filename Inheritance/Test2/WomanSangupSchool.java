package kr.or.kh02;

import java.util.Scanner;

public class WomanSangupSchool extends WomanSchool {
	private static final Scanner scanner = new Scanner(System.in);
	private int sangup;
	
	public int getSangup() {
		return sangup;
	}

	public void setSangup(int sangup) {
		this.sangup = sangup;
	}

	public String womanSangupInfo() {
		return "국어 : " + getKor() + " 영어 : " + getEng() + " 수학 : " + getMath() + " 가정: " + getGajong()+ " 상업: " + getSangup() + 
				" 총점 : " + total() + " 평균 : " + avg();
	}
	
	public int total() {
		return super.total()+sangup;
	}

	public double avg() {
		return total()/5.0;
	}
	
	protected static void inputWomanSangupSchool(WomanSangupSchool womansangupschool) {
		System.out.print("국어 : ");
		womansangupschool.setKor(scanner.nextInt());
		System.out.print("영어 : ");
		womansangupschool.setEng(scanner.nextInt());
		System.out.print("수학 : ");
		womansangupschool.setMath(scanner.nextInt());
		System.out.print("가정 : ");
		womansangupschool.setGajong(scanner.nextInt());
		System.out.print("상업 : ");
		womansangupschool.setSangup(scanner.nextInt());
	}
}
