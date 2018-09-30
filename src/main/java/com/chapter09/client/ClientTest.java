package com.chapter09.client;

import com.chapter09.business.ICakeService;

public class ClientTest {
	public static void main(String[] args) {
		ProxyHandler proxyHandler = new ProxyHandler("127.0.0.1", 20006);
		
		ICakeService batterCakeService = proxyHandler.getProxy(ICakeService.class);
		System.out.println(batterCakeService.sellBatterCake("双蛋"));
		System.out.println(batterCakeService.plus(1, 2));
		
	}
}