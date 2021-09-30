package kr.or.kh06;

public class Eagle extends Animal {
	@Override
	protected void move() {
		System.out.println("독수리가 날아갑니다.");
	}

	private void flying() {
		System.out.println("독수리가 하늘을 납니다");
	}
}
