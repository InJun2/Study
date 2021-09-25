package kr.or.kh02;

import java.util.Scanner;

public class ManSchool extends SChool {
	private static final Scanner scanner = new Scanner(System.in);
	private int gis;
	
	public String manInfo() {
		return "국어 : " + getKor() + " 영어 : " + getEng() + " 수학 : " + getMath() + " 기술: " + getGis() + " 총점 : " + total() + " 평균 : " + avg();
	}
	
	public int getGis() {
		return gis;
	}

	public void setGis(int gis) {
		this.gis = gis;
	}
	
	public int total() {
		return super.total()+gis;
	}

	public double avg() {
		return total()/4.0;
	}

	protected static void inputManSchool(ManSchool manschool) {
		inputSchool(manschool);
		System.out.print("기술 : ");
		manschool.setGis(scanner.nextInt());
	}

}
