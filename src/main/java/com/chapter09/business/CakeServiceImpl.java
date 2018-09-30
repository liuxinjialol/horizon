package com.chapter09.business;

public class CakeServiceImpl implements ICakeService {
	
	public String sellBatterCake(String name) {
		return name + "煎饼,卖的特别好";
	}

	public int plus(int a, int b) {
		return a+b;
	}

}