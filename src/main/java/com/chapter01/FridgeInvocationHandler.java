package com.chapter01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FridgeInvocationHandler implements InvocationHandler{
	
	private Object target;
	
	public FridgeInvocationHandler(Object target) {
		this.target=target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object result=method.invoke(target, args);
		after();
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	private void before(){
	    System.out.println("打开冰箱门");
	}
	
	private void after(){
	    System.out.println("关上冰箱门");
	}
	
}
