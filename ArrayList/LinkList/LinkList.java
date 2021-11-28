package Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkList {
	public static void main(String[] args) {
		LinkedList<Integer> num = new LinkedList<>();	// integer 값을 저장하는 linklist
		LinkedList<Integer> num2 = new LinkedList<>(Arrays.asList(1,2,3));	
		// integer 값 형식의 linklist생성 및 1,2,3을 저장
		
		num2.addFirst(1);//가장 앞에 데이터 추가
		num2.addLast(2);//가장 뒤에 데이터 추가
		num2.add(3);//데이터 추가
		num2.add(1, 10);//index 1에 데이터 10 추가
		
		num2.removeFirst(); //가장 앞의 데이터 제거
		num2.removeLast(); //가장 뒤의 데이터 제거
		num2.remove(); //생략시 0번째 index제거
		num2.remove(1); //index 1 제거
		num.clear(); //모든 값 제거
		
		System.out.println(num2.size()); 		//list 크기 : 3
		System.out.println(num2.get(0));		//0번째 index 출력
		
		for(Integer i : num2) { 		//for문을 통한 전체출력
		    System.out.print(i + " ");
		}
		
		System.out.println();

		Iterator<Integer> iter = num2.iterator();	//Iterator 선언 
		while(iter.hasNext()){				// 다음값이 있는지 체크
		    System.out.print(iter.next() + " "); 	// 값 출력
		}
		
		System.out.println("\nlist에 1이 있는지 검색 : "+num2.contains(1)); 		    //list에 1이 있는지 검색 : true
		System.out.println("list에 1 위치 검색 및 해당 인덱스 : " + num2.indexOf(1)); 	//1이 있는 index반환 없으면 -1
	}
}
