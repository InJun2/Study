package kr.or.kh02;

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
}
