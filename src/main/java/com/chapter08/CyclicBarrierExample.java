package com.chapter08;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier --> ReentrantLock
 *
 */

public class CyclicBarrierExample {
	public static void main(String[] args) {
		Runnable barrierAction = new Runnable() {
			@Override
			public void run() {
				System.out.println("统计C,D,E,F盘");
			}
		};

		final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, barrierAction);

		Runnable runC = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("C盘");
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}

			}
		};

		Runnable runD = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("D盘");
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}

			}
		};

		Runnable runE = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("E盘");
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}

			}
		};

		Runnable runF = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("F盘");
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}

			}
		};

		ExecutorService service = Executors.newFixedThreadPool(4);
		service.submit(runC);
		service.submit(runD);
		service.submit(runE);
		service.submit(runF);
		service.shutdown();
	}
}