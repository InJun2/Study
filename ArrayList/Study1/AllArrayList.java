package Test;

public class AllArrayList {

	public AllArrayList(Person per) {
		printPerson(per);
	}

	private void printPerson(Person per) {
		for(Student student : per.getStu()){
			student.getInfo();
		}
		for(Professor professor : per.getPro()) {
			professor.getInfo();
		}
		for(Manager manager : per.getMan()) {
			manager.getInfo();
		}
	}
	
}
