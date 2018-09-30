package com.chapter09.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ServerRegister {
	// 存储注册的服务列表
	private static List<Object> serviceList;

	public static void register(int port, Object... services) throws Exception {
		System.out.println("server start ...");
		serviceList = Arrays.asList(services);
		ServerSocket server = new ServerSocket(port);
		Socket client = null;
		while (true) { // 阻塞等待输入
			client = server.accept(); // 每一个请求，启动一个线程处理
			new Thread(new ServerRunnable(client, serviceList)).start();
		}
	}
}