package com.chapter09.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class ProxyHandler implements InvocationHandler {

	private String ip;

	private int port;

	public ProxyHandler(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Socket client = new Socket(this.ip, this.port);
		ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(client.getInputStream());
		try {
			output.writeObject(proxy.getClass().getInterfaces()[0]);
			output.writeUTF(method.getName());
			output.writeObject(method.getParameterTypes());
			output.writeObject(args);
			output.flush();
			Object result = input.readObject();
			if (result instanceof Throwable) {
				throw (Throwable) result;
			}
			return result;
		} finally {
			client.shutdownOutput();
		}
	}
	
	public <T> T getProxy(Class<T> clz) {
		return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] {clz}, this);
	}

}