package Test;
// 추상 메소드를 가진 추상 클래스
// 클래스들의 공통 사항을 한 곳에서 관리할 수 있기 때문에 개발 및 유지보수가 편리해짐
// 메소드 내용이 상속받는 클래스에 따라 달라지기 때문에 추상 메소드 사용
// 구현부는 해당 클래스를 상속받는 하위 클래스에서 반드시 작성해야 함 {}구현부를 작성하지 않은 경우 에러 발생
// 오버라이딩 메소드에는 abstract를 작성하지 않음
abstract class Exam {
	public int sum(int x, int y) {
		return x + y;
	}

	// 밑에는 추상 메소드, 하위 클래스에서 오버라이딩을 완료해야 함 
	abstract public void sayHi();

	abstract public void printSum(int a, int b);

}
