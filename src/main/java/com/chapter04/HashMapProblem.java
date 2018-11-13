package com.chapter04;

import java.util.HashMap;
import java.util.Map;

public class HashMapProblem {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		for (int i = 10; i < 100; i++) {
			MyThread myThread = new MyThread(map, "线程名字：" + i);
			myThread.start();
		}
	}

	static class MyThread extends Thread {
		public Map map;
		public String name;

		public MyThread(Map map, String name) {
			this.map = map;
			this.name = name;
		}

		public void run() {
			double i = Math.random() * 1000000;
			map.put("键" + i, "值" + i);

			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			map.remove("键" + i);
			System.out.println(name + " 当前时间：" + System.currentTimeMillis() + "   size = " + map.size());
		}
	}

}
