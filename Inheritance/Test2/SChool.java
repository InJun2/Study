package kr.or.kh02;

import java.util.Scanner;

public class SChool {
	private int kor;
	private int eng;
	private int math;
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public String SchoolInfo() {
		return "국어 : " + getKor() + " 영어 : " + getEng() + " 수학 : " + getMath() + " 총점 : " + total() + " 평균 : " + avg();
	}
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	// 
	public int total() {
		return kor+eng+math;
	}
	public double avg() {
		return total()/3.0;
	}
	
	protected static void inputSchool(SChool school) {
		System.out.print("국어 : ");
		school.setKor(scanner.nextInt());
		System.out.print("영어 : ");
		school.setEng(scanner.nextInt());
		System.out.print("수학 : ");
		school.setMath(scanner.nextInt());
	}
	
	
	
}
