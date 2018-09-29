package com.chapter04;

import java.util.IdentityHashMap;

/**
 * 
 IdentityHashMap要求两个key严格相等才认为两个key相等。
 IdentityHashMap不保证key-value对之间的顺序，更不能保证它们的顺序随时间的推移保持不变。
 *
 */


public class IdentityHashMapTest {

	public static void main(String[] args) {
		IdentityHashMap idenmap = new IdentityHashMap();
		idenmap.put(new String("语文"), 80);
		idenmap.put(new String("语文"), 89);

		idenmap.put("java", 80);
		idenmap.put("java", 80);
		System.out.println(idenmap);
	}
}
