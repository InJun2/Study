package kr.or.kh02;

public class ManSchool extends SChool {
	private int gis;
	
	public String manInfo() {
		return "국어 : " + getKor() + "영어 : " + getEng() + "수학 : " + getMath() + " 기술: " + getGis();
	}
	
	public int getGis() {
		return gis;
	}

	public void setGis(int gis) {
		this.gis = gis;
	}

}
