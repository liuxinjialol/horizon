package com.chapter08;


/**
 *
 * 在调用 join() 方法的程序中，原来的多个线程仍然多个线程，并没有发生“合并为一个单线程”。
 * 真正发生的是调用 join() 的线程进入 TIMED_WAITING 状态，等待 join() 所属线程运行结束后再继续运行
 * 
 * 代码中是main线程进入TIMED_WAITING,所以Tx线程不会start
 *
 */


public class JoinExample {
	
	public static void main(String[] args) throws Exception {
		Runnable runC = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(6000);
					System.out.println("统计C盘");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable runD = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println("统计D盘");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable runE = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println("统计E盘");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable runF = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("统计F盘");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable runX = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("汇总");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		
		Thread Tc=new Thread(runC);
		Thread Td=new Thread(runD);
		Thread Te=new Thread(runE);
		Thread Tf=new Thread(runF);
		
		long t1=System.currentTimeMillis();
		
		Tc.start();
		Td.start();
		Te.start();
		Tf.start();
		
		Tc.join();
		Td.join();
		Te.join();
		Tf.join();
		
		System.out.println(System.currentTimeMillis()-t1);
		
		Thread Tx=new Thread(runX);
		Tx.start();
		Tx.join();
		
	}

}