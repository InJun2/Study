package Test;

import java.util.ArrayList;
import java.util.Scanner;

public class FindArrayList {
	
	private final Scanner sc = new Scanner(System.in);
	
	
	FindArrayList(Person per) {
		boolean searchresult = false;
		System.out.println("ã�� �̸��� �Է����ּ���");
		String name = sc.next();
		for(int i=0;i<per.list.size();i++) {
			Person person = per.list.get(i);
			System.out.println(person.getName(person));
				
			searchresult = true;
		}
		
		if(!searchresult) {
			System.out.println("�˻��� �����Ͽ����ϴ�");
		}
	}
	
	
}
