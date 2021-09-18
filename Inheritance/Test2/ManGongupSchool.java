package kr.or.kh02;

public class ManGongupSchool extends ManSchool {
	private int gongup;

	public String manGongupInfo() {
		return "국어 : " + getKor() + "영어 : " + getEng() + "수학 : " + getMath() + " 기술: " + getGis()+" 공업: " + getGongup();
	}
	
	public int getGongup() {
		return gongup;
	}

	public void setGongup(int gongup) {
		this.gongup = gongup;
	}
	
	
}
