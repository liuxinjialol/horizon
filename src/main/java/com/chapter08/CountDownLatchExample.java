package com.chapter08;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample{
public static void main(String[] args) throws Exception {
        //创建一个能容纳4个线程的减数器
        final CountDownLatch countDownLatch= new CountDownLatch(4);
        Runnable runC= new Runnable() {
             
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("统计C盘");
                    countDownLatch.countDown();//单任务，把计数器减1
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        Runnable runD= new Runnable() {
             
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("统计D盘");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        Runnable runE= new Runnable() {
             
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("统计E盘");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        Runnable runF= new Runnable() {
             
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("统计F盘");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
         
        ExecutorService service= Executors.newFixedThreadPool(4);
        service.submit(runC);
        service.submit(runD);
        service.submit(runE);
        service.submit(runF);
         
        countDownLatch.await();//主线程，即第5线程等待
        System.out.println("合计C,D,E,F");
        service.shutdown();
}
 
}