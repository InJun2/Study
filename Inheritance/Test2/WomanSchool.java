package kr.or.kh02;

import java.util.Scanner;

public class WomanSchool extends SChool {
	private int gajong;

	public String womanInfo() {
		return "국어 : " + getKor() + "영어 : " + getEng() + "수학 : " + getMath() + " 가정: " + getGajong();
	}
	
	public void setGajong(int gajong) {
		this.gajong = gajong;
	}
	
	public int getGajong() {
		return gajong;
	}
	
	protected static void inputWomanSchool(Scanner scanner) {
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
	
}
