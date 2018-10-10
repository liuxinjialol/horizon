package com.chapter06;

import java.lang.reflect.Method;

public class Test {
	
	public static void main(String[] args) throws Exception{
		
		/**
		 * Class.forName也是调用的loadClass，参数为true，执行类的static模块
		 * 
		 * ClassLoader调用的loadClas，参数为flase，不执行类的static模块，newInstance时候执行
		 * 
		 */
		
		Class.forName("com.chapter06.Person");
		
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		loader.loadClass("com.chapter06.Person").newInstance();
		
		/**
		 * ===========================================================================
		 */
		
		Class<?> c=ClassUtil.loadClass("com.chapter06.Person");
		Person person=(Person)c.newInstance();
		
		Method work=c.getDeclaredMethod("work");
		System.out.println(work.invoke(person));
		
		Method eat=c.getDeclaredMethod("eat",String.class);
		System.out.println(eat.invoke(person,"apple"));
		
	}

}
