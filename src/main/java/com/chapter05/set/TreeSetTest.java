package com.chapter05.set;

import java.util.TreeSet;


/**

TreeSet内部存储是TreeMap,其中key是Set添加的对象，值为final的Object对象，自动排序

 */

public class TreeSetTest {
	public static void main(String[] args) {

		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("java");
		treeSet.add("php");
		treeSet.add("python");
		treeSet.add("java");
		System.out.println(treeSet);
		
	}
}
