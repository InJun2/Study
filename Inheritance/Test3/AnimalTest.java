package kr.or.kh06;

import java.util.ArrayList;
import java.util.List;

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
		test.testDownCasting(tAnimal);	// 오류
	}
	
	private void moveAnimal(List<Animal> animallist) {
		for(Animal animal : animallist) {
			animal.move();
		}
	}
	
	private void testDownCasting(Animal animal) {	// 다른 참조변수가 들어올수도있기에 컴파일러는 허락하지 않음
		Human human = (Human) animal;
		human.readbook();
	}
	
	private void setAnimalList(Animal animal) {
		animalList.add(animal);
	}
	
	protected List<Animal>getAnimalList(){
		return this.animalList;
	}
}
