package com.chapter10;

public class Counter {

	private static int num = 0;
	
	private Object lock = new Object();
	
//unsafe
//	public void incr() {
//		num++;
//	}
	
//	public  void incr() {
//		synchronized(this) {
//			num++;
//		}
//	}
	
//	public  void incr() {
//		synchronized(Counter.class) {
//			num++;
//		}
//	}

	public  void incr() {
		synchronized(lock) {
			num++;
		}
	}
	
//	public synchronized void incr() {
//		num++;
//	}

	public int get() {
		return num;
	}

	public static void main(String[] args) throws Exception {
		Counter c = new Counter();
		Thread[] array = new Thread[1000];
		for (int i = 0; i < 1000; i++) {
			array[i] = new CounterThread(c);
			array[i].start();
		}
		for (int j = 0; j < 1000; j++) {
			array[j].join();
		}

		System.out.println(c.get());

	}

}
