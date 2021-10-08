package Test;

public class AbstractTest extends Exam {

	public void sayHi() {
		System.out.println("안녕?");
	}


	public void printSum(int a, int b) {
		int result = sum(a,b);
		System.out.println(a + "과(와) " + b + "의 합은 " + result + "(이)야");
	}

	public static void main(String[] args) {

		// 하위 클래스인 AbstractTest 객체 생성
		AbstractTest at = new AbstractTest();


		at.sayHi(); 
		at.printSum(30, 40); 

	}

}
