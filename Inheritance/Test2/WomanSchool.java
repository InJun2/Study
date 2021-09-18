package kr.or.kh02;

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
	
}
