package kr.or23;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		//  key와 value가 String인 HashMap 으로 구성된 ArrayList 생성
		ArrayList<HashMap<String,String>> haksaList = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> hashMap = new HashMap<>();
		// HashMap은 key와 밸류로 구성, 생성 시 키와 밸류 타입 명시하여 생성
		HashMap<String,String> hashMap2 = new HashMap<>();
		hashMap.put("age","25");
		hashMap.put("name", "HwangInJun");
		
		hashMap2.put("age", "26");
		hashMap2.put("name", "GoGilDong");
		
		haksaList.add(hashMap);
		haksaList.add(hashMap2);
		
		for(HashMap<String,String> haksa : haksaList) {
			System.out.println(haksa.get("age")+" "+haksa.get("name"));
		} // 키 age와 name의 값 가져오기
	}
}
