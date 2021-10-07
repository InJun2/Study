package kr.or23;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		ArrayList<HashMap<String,String>> haksaList = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> hashMap = new HashMap<>();
		HashMap<String,String> hashMap2 = new HashMap<>();
		hashMap.put("age","25");
		hashMap.put("name", "HwangInJun");
		
		hashMap2.put("age", "26");
		hashMap2.put("name", "GoGilDong");
		
		haksaList.add(hashMap);
		haksaList.add(hashMap2);
		
		for(HashMap<String,String> haksa : haksaList) {
			System.out.println(haksa.get("age")+" "+haksa.get("name"));
		}
	}
}
