package com.chapter09;

public class CrossPrint {

	private Object object = new Object();

	private int i = 0;

	class Thread1 extends Thread {

		@Override
		public void run() {
			while (i<10) {
				try {
					synchronized (object) {
						System.out.println("X");
						object.notify();
						object.wait();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				i++;
			}
		}
	}

	class Thread2 extends Thread {

		@Override
		public void run() {
			while (i<10) {
				try {
					synchronized (object) {
						System.out.println("O");
						object.notify();
						object.wait();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				i++;
			}
		}
	}

	public void exec() {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		CrossPrint cp = new CrossPrint();
		cp.exec();
	}

}
