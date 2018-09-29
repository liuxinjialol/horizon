package com.chapter05.set;

import java.util.LinkedHashSet;

/**

LinkedHashSet内部存储是LinkedHashMap,其中key是Set添加的对象，值为final的Object对象，链表顺序

 */

public class LinkedHashSetTest {
	public static void main(String[] args) {

		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("java");
		linkedHashSet.add("php");
		linkedHashSet.add("python");
		linkedHashSet.add("java");
		System.out.println(linkedHashSet);
		
	}
}
