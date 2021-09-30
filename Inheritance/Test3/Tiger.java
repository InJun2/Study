package kr.or.kh06;

public class Tiger extends Animal {
	@Override
	protected void move() {
		System.out.println("호랑이가 움직입니다");
	}
	private void hunting() {
		System.out.println("호랑이가 사냥합니다");
	}
}
