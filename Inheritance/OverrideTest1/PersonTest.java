package kr.or.kh05;

public class PersonTest {
	public static void main(String[] args) {
		Person person1 = new Employee();	// ��ĳ���� ��� �θ�Ŭ������ Person���� ��, �׷��� �������̵��� ���� ������ �߱⶧���� ��� �ڽ�Ŭ������ Employee()�� personDisp() �޼ҵ尡 �����
		person1.personDisp();
		ShowDisp(person1);
		// ��ĳ������ Person person1 = (Person) new Employee();�� ���� , �����Ϸ����� �˾Ƽ� ���ִ� ��
		
		Person person2 = new Student();		// ��ĳ����
		person2.personDisp();
		ShowDisp(person2);
		
		President president = new President();
		Person person3 = president;			// ��ĳ����
		person3.personDisp();
		ShowDisp(person3);
		
		Person person4 = new Parents();		// ��ĳ����, Parents() Ŭ���������� �����ϰ� �������̵������� �ʾ� Person�� �޼ҵ��� personDisp()�� ȣ���
		person4.personDisp();
		ShowDisp(person4);
		
	}
	
	public static void ShowDisp(Person person) {	// �̷� ������ �޼ҵ�� Ȯ�� ���� (  personDisp �޼ҵ带 �������̵� �� Ŭ������ �ڽ�Ŭ������ personDisp ����� )
		person.personDisp();
	}
}
