package kr.or.kh02;

public class ManSchool extends SChool {
	private int gis;
	
	public String manInfo() {
		return "���� : " + getKor() + "���� : " + getEng() + "���� : " + getMath() + " ���: " + getGis();
	}
	
	public int getGis() {
		return gis;
	}

	public void setGis(int gis) {
		this.gis = gis;
	}

}
