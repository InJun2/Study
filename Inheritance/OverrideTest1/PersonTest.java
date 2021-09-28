package kr.or.kh05;

public class PersonTest {
	public static void main(String[] args) {
		Person person1 = new Employee();	// 업캐스팅 모두 부모클래스인 Person으로 들어감, 그러나 오버라이딩을 통해 재정의 했기때문에 모두 자식클래스인 Employee()의 personDisp() 메소드가 실행됨
		person1.personDisp();
		ShowDisp(person1);
		// 업캐스팅은 Person person1 = (Person) new Employee();와 같다 , 컴파일러에서 알아서 해주는 것
		
		Person person2 = new Student();		// 업캐스팅
		person2.personDisp();
		ShowDisp(person2);
		
		President president = new President();
		Person person3 = president;			// 업캐스팅
		person3.personDisp();
		ShowDisp(person3);
		
		Person person4 = new Parents();		// 업캐스팅, Parents() 클래스에서는 유일하게 오버라이딩을하지 않아 Person의 메소드인 personDisp()가 호출됨
		person4.personDisp();
		ShowDisp(person4);
		
	}
	
	public static void ShowDisp(Person person) {	// 이런 식으로 메소드로 확인 가능 (  personDisp 메소드를 오버라이딩 한 클래스는 자식클래스의 personDisp 실행됨 )
		person.personDisp();
	}
}
