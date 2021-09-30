package kr.or.kh06;

public class Human extends Animal {
	@Override
	protected void move() {
		System.out.println("사람이 걷습니다");
	}
	private void readbook() {
		System.out.println("사람이 책을 읽습니다");
	}
	
}
