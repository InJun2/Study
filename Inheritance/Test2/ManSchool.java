package kr.or.kh02;

import java.util.Scanner;

public class ManSchool extends SChool {
	private int gis;
	
	public String manInfo() {
		return "국어 : " + getKor() + "영어 : " + getEng() + "수학 : " + getMath() + " 기술: " + getGis();
	}
	
	public int getGis() {
		return gis;
	}

	public void setGis(int gis) {
		this.gis = gis;
	}
	
	protected static void inputManSchool(Scanner scanner) {
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

}
