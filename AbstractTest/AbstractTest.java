package Test;

public class AbstractTest extends Exam {
	// Exam Ŭ������ sayHi() �߻� �޼ҵ� �������̵�
	public void sayHi() {
		System.out.println("�ȳ�?");
	}

	// Exam Ŭ������ printSum() �߻� �޼ҵ� �������̵�
	public void printSum(int a, int b) {
		int result = sum(a,b);
		System.out.println(a + "��(��) " + b + "�� ���� " + result + "(��)��");
	}

	public static void main(String[] args) {

		// ���� Ŭ������ AbstractTest ��ü ����
		AbstractTest at = new AbstractTest();

		// AbstractTest Ŭ�������� �����ǵ� �޼ҵ� ȣ��
		at.sayHi(); 
		at.printSum(30, 40); 

	}

}