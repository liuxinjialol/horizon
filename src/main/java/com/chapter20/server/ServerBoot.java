package com.chapter20.server;

import com.chapter20.business.CakeServiceImpl;
import com.chapter20.business.ICakeService;

public class ServerBoot {
	public static void main(String[] args) throws Exception {
		ICakeService batterCakeService = new CakeServiceImpl();
		ServerRegister.register(20006, batterCakeService);
	}
}