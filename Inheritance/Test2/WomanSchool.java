package kr.or.kh02;

public class WomanSchool extends SChool {
	private int gajong;

	public String womanInfo() {
		return "���� : " + getKor() + "���� : " + getEng() + "���� : " + getMath() + " ����: " + getGajong();
	}
	
	public void setGajong(int gajong) {
		this.gajong = gajong;
	}
	
	public int getGajong() {
		return gajong;
	}
	
}
