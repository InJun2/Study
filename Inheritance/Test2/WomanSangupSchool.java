package kr.or.kh02;

import java.util.Scanner;

public class WomanSangupSchool extends WomanSchool {
	private int sangup;
	
	public int getSangup() {
		return sangup;
	}

	public void setSangup(int sangup) {
		this.sangup = sangup;
	}

	public String womanSangupInfo() {
		return "국어 : " + getKor() + "영어 : " + getEng() + "수학 : " + getMath() + " 가정: " + getGajong()+ " 상업: " + getSangup();
	}
	
	protected static void inputWomanSangupSchool(Scanner scanner) {
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
