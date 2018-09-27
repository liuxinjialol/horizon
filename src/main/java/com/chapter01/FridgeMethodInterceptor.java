package com.chapter01;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class FridgeMethodInterceptor implements MethodInterceptor {
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls) {
		return (T) Enhancer.create(cls,this);
	}
	
	public Object intercept(Object obj,Method method,Object[] args,MethodProxy proxy) throws Throwable{
		before();
		Object result=proxy.invokeSuper(obj,args);
		after();
		return result;
	}
	
	private void before(){
	    System.out.println("打开冰箱门");
	}
	
	private void after(){
	    System.out.println("关上冰箱门");
	}
	
}

