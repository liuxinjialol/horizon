package com.chapter04;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<>();
		linkedHashMap.put("php", "best");
		linkedHashMap.put("java", "good");
		linkedHashMap.put("golang", "poor");
		System.out.println(linkedHashMap);
	}
}
