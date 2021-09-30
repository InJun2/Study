package kr.or.kh06;

import java.util.ArrayList;
import java.util.List;

public class AnimalTest {
	private List<Animal> animalList = new ArrayList<>();

	public static void main(String[] args) {
		Animal hAnimal = new Human();	// ���ɽ���
		Animal tAnimal = new Tiger();	// ���ɽ���
		Animal eAnimal = new Eagle();	// ���ɽ���
		
		AnimalTest test = new AnimalTest();
		test.setAnimalList(hAnimal);
		test.setAnimalList(tAnimal);
		test.setAnimalList(eAnimal);
		
		test.moveAnimal(test.getAnimalList());
		
		test.testDownCasting(hAnimal);	// ���ɽ����ߴ� Human��ü �ٿ�ĳ����
		test.testDownCasting(tAnimal);	// ����
	}
	
	private void moveAnimal(List<Animal> animallist) {
		for(Animal animal : animallist) {
			animal.move();
		}
	}
	
	private void testDownCasting(Animal animal) {	// �ٸ� ���������� ���ü����ֱ⿡ �����Ϸ��� ������� ����
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
