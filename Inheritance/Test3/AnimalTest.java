package kr.or.kh06;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class AnimalTest {
	private List<Animal> animalList = new ArrayList<>();

	public static void main(String[] args) {
		Animal hAnimal = new Human();	// 업케스팅
		Animal tAnimal = new Tiger();	// 업케스팅
		Animal eAnimal = new Eagle();	// 업케스팅
		
		AnimalTest test = new AnimalTest();
		test.setAnimalList(hAnimal);
		test.setAnimalList(tAnimal);
		test.setAnimalList(eAnimal);
		
		test.moveAnimal(test.getAnimalList());
		
		test.testDownCasting(hAnimal);	// 업케스팅했던 Human객체 다운캐스팅
//		test.testDownCasting(tAnimal);	// 오류
		
		test.testDownCastinglist(test.getAnimalList());
	}
	
	private void moveAnimal(List<Animal> animallist) {
		for(Animal animal : animallist) {
			animal.move();
		}
	}
	
	private void testDownCasting(Animal animal) {	// 다른 참조변수가 들어올수도있기에 컴파일러는 허락하지 않음, Human이 아닌 다른 Animal클래스를 포함한 자식클래스면 오류 
		Human human = (Human) animal;
		human.readbook();
	}
	
	private void testDownCastinglist(List<Animal>list) {
		for(Animal animal : list) {
			if(animal instanceof Human) {			// 위와 다르게 instanceof를 이용하여 animal객체가 Human클래스인지 확인
				Human human = (Human) animal;		// 이런식의 코드는 길어지면서 제한도 되어있기때문에 좋은코드는 아님 업캐스팅을 이용한 코드가 좋다고함
				human.readbook();
				continue;
			}
			if(animal instanceof Tiger) {
				Tiger tiger = (Tiger) animal;
				tiger.hunting();
				continue;
			}
			if(animal instanceof Eagle) {
				Eagle eagle = (Eagle) animal;
				eagle.flying();
				continue;
			}
			throw new RuntimeException("잘못된 클래스");
		}
	}
	
	private void setAnimalList(Animal animal) {
		animalList.add(animal);
	}
	
	protected List<Animal>getAnimalList(){
		return this.animalList;
	}
}
