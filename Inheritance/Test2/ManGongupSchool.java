package kr.or.kh02;

public class ManGongupSchool extends ManSchool {
	private int gongup;

	public String manGongupInfo() {
		return "���� : " + getKor() + "���� : " + getEng() + "���� : " + getMath() + " ���: " + getGis()+" ����: " + getGongup();
	}
	
	public int getGongup() {
		return gongup;
	}

	public void setGongup(int gongup) {
		this.gongup = gongup;
	}
	
	
}
