package com.chapter04;

import java.util.WeakHashMap;

/**
 * 
HashMap的key保留了对实际对象的强引用，这意味着只要HashMap对象不被销毁，
还HashMap的所有key所引用的对象就不会被垃圾回收，HashMap也不会自动删除这些key所对应的key-value对；

WeakHashMap的key只保留对实际对象的弱引用，这意味着如果WeakHashMap对象的key所引用的对象没有被其他强引用变量所引用，
则这些key所引用的对象可能被垃圾回收，WeakHashMap也可能自动删除这些key所对应的key-value对。

WeakHashMap中的每个key对象只持有对实际对象的弱引用，因此，当垃圾回收了该key所对应的实际对象之后，WeakHashMap会自动删除该key对应的key-value对

*/


public class WeakHashMapTest {
	
	public static void main(String[] args) {
		
		WeakHashMap<String,String> wak = new WeakHashMap<>();
		// 两个key都是匿名字符串对象（没有其他引用）
		wak.put(new String("数学"), new String("优良"));
		wak.put(new String("语文"), new String("良好"));

		// 该key是一个系统缓存的字符串对象
		wak.put("外语", new String("好"));
		
		String course="体育";
		wak.put(course, new String("差"));
		System.out.println(wak);

		System.gc();
		System.runFinalization();
		
		System.out.println(wak);

	}
}
