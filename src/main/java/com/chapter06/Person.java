package com.chapter06;

public class Person {
	
	static  {
		System.out.println("init method");
	}
	
	String name;
	
	int age;
	
	public String eat(String food) {
		return "eat an "+food;
	}
	
	public String work() {
		return "work hard";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
