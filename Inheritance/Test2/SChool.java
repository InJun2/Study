package kr.or.kh02;

public class SChool {
	private int kor;
	private int eng;
	private int math;
	
	public String SchoolInfo() {
		return "���� : " + getKor() + "���� : " + getEng() + "���� : " + getMath();
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
	
	
	
	
}
