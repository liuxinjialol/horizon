package com.chapter06;

import java.lang.reflect.Method;

public class Person {
	
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
	
	public static void main(String[] args) throws Exception{
		Class<?> c=ClassUtil.loadClass("com.chapter06.Person");
		Person person=(Person)c.newInstance();
		
		Method work=c.getDeclaredMethod("work");
		System.out.println(work.invoke(person));
		
		Method eat=c.getDeclaredMethod("eat",String.class);
		System.out.println(eat.invoke(person,"apple"));
	}

}
