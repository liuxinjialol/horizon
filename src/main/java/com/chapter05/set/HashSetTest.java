package com.chapter05.set;

import java.util.HashSet;

/**

HashSet内部存储是HashMap,其中key是Set添加的对象，值为final的Object对象，无序的

 */

public class HashSetTest {
	public static void main(String[] args) {

		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("java");
		hashSet.add("php");
		hashSet.add("python");
		hashSet.add("java");
		System.out.println(hashSet);
		
	}
}
