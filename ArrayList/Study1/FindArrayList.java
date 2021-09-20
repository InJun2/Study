package Test;

import java.util.ArrayList;
import java.util.Scanner;

public class FindArrayList {
	
	private final Scanner sc = new Scanner(System.in);
	
	
	FindArrayList(Person per) {
		boolean searchresult = false;
		System.out.println("찾을 이름을 입력해주세요");
		String name = sc.next();
		for(int i=0;i<per.list.size();i++) {
			Person person = per.list.get(i);
			System.out.println(person.getName(person));
				
			searchresult = true;
		}
		
		if(!searchresult) {
			System.out.println("검색에 실패하였습니다");
		}
	}
	
	
}
