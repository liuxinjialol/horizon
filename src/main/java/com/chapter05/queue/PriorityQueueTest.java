package com.chapter05.queue;

import java.util.ArrayDeque;

public class PriorityQueueTest {
	public static void main(String[] args) {

		ArrayDeque<String> arrayDeque = new ArrayDeque<>();
		arrayDeque.add("java");
		arrayDeque.add("php");
		arrayDeque.add("python");
		arrayDeque.addFirst("c#");
		arrayDeque.addLast("sql");
		System.out.println(arrayDeque);
		
	}
}
