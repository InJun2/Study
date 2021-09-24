package kr.or.kh02;

public class SChool {
	private int kor;
	private int eng;
	private int math;
	
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
	
	
	
}
