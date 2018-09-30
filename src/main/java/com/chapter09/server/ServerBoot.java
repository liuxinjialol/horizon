package com.chapter09.server;

import com.chapter09.business.CakeServiceImpl;
import com.chapter09.business.ICakeService;

public class ServerBoot {
	public static void main(String[] args) throws Exception {
		ICakeService batterCakeService = new CakeServiceImpl();
		ServerRegister.register(20006, batterCakeService);
	}
}