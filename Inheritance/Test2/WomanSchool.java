package kr.or.kh02;

import java.util.Scanner;

public class WomanSchool extends SChool {
	private static final Scanner scanner = new Scanner(System.in);
	private int gajong;

	public String womanInfo() {
		return "국어 : " + getKor() + " 영어 : " + getEng() + " 수학 : " + getMath() + " 가정: " + getGajong()
		+ " 총점 : " + total() + " 평균 : " + avg();
	}
	
	public void setGajong(int gajong) {
		this.gajong = gajong;
	}
	
	public int getGajong() {
		return gajong;
	}
	
	public int total() {
		return super.total()+gajong;
	}

	public double avg() {
		return total()/4.0;
	}
	
	protected static void inputWomanSchool(WomanSchool womanschool) {
		System.out.print("국어 : ");
		womanschool.setKor(scanner.nextInt());
		System.out.print("영어 : ");
		womanschool.setEng(scanner.nextInt());
		System.out.print("수학 : ");
		womanschool.setMath(scanner.nextInt());
		System.out.print("가정 : ");
		womanschool.setGajong(scanner.nextInt());
	}
	
}
