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
		return "���� : " + getKor() + "���� : " + getEng() + "���� : " + getMath() + " ����: " + getGajong()+ " ���: " + getSangup();
	}
}
