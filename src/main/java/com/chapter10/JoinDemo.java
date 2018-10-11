package com.chapter10;

public class JoinDemo extends Thread{

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println("sleep is over");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		JoinDemo demo=new JoinDemo();
		demo.start();
		demo.join(3000);
//		demo.interrupt();
		System.out.println("here...");
	}
	
	

}
