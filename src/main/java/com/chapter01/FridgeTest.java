package com.chapter01;

public class FridgeTest {
	
	public static void main(String[] args) {

		Fridge fridge = new FridgeImpl();
		fridge.put("大象");
		System.out.println("----------------------------");

		FridgeInvocationHandler handler = new FridgeInvocationHandler(fridge);
		fridge = handler.getProxy();
		fridge.put("泰国象");
		System.out.println("----------------------------");

		FridgeMethodInterceptor cglib = new FridgeMethodInterceptor();
		fridge = cglib.getProxy(FridgeImpl.class);
		fridge.put("原始象");

	}

}
