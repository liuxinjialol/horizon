package com.chapter04;

import java.util.*;

/**
 * TreeMap是有序的
 *
 */

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<String, String> treeMap = new TreeMap<>();
		for (int i = 0; i < 4; i++) {
			String s = "" + (int) (Math.random() * 1000);
			treeMap.put(s, s);
		}
		treeMap.put("abcd", "abcd");
		treeMap.put("Abc", "Abc");
		treeMap.put("bbb", "bbb");
		treeMap.put("BBBB", "BBBB");
		treeMap.put("北京", "北京");
		treeMap.put("中国", "中国");
		treeMap.put("厦门", "厦门");
		treeMap.put("香港", "香港");
		treeMap.put("碑海", "碑海");
		Collection col = treeMap.values();
		Iterator it = col.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
