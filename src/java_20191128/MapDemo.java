package java_20191128;

import java.util.HashMap;
import java.util.Iterator;

public class MapDemo {
	public static void main(String[] args) {
		// key value 
		// value 의 중복 허요 key의  중복 덮어쓰기
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		
		map.put("1",1111);
		map.put("2",2222);
		map.put("3",3333);
		map.put("4",4444);
		map.put("1",5555);
		
		map.get("1");
		
		Iterator<String> s = map.keySet().iterator();
		
		while(s.hasNext()){
			String k = s.next();
			Integer v = map.get(k);
			System.out.format("key: %s value: %d %n",k,v);
		}
		
	}
}
