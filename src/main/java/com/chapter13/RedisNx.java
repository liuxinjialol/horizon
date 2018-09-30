package com.chapter13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

public class RedisNx {

	public static void main(String[] args) {
		
		JedisPool pool = null;
		String ip = "192.168.1.62";
		int port = 6379;
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(10000);
		config.setMaxWaitMillis(1000 * 100);
		config.setTestOnBorrow(true);
		pool = new JedisPool(config, ip, port, 100000);
		Jedis jedis = pool.getResource();
		
		jedis.del("player");
		try {

			ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
			int clientNum = 10;// 模拟客户数目
			for (int i = 0; i < clientNum; i++) {
				cachedThreadPool.execute(new PlayerThread(i,pool));
			}
			cachedThreadPool.shutdown();

			while (true) {
				if (cachedThreadPool.isTerminated()) {
					System.out.println("所有的线程都结束了！");
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(jedis.get("player"));
			
		}catch(Exception e) {
			
		}finally {
			pool.returnResource(jedis);
		}
		
	}

}



class PlayerThread implements Runnable {
	Jedis jedis = null;
	String key = "football";// 商品主键
	String clientList = "clientList";//// 抢购到商品的顾客列表主键
	String clientName;
	JedisPool jedisPool;

	public PlayerThread(int num,JedisPool pool) {
		clientName = "编号=" + num;
		jedis=pool.getResource();
		jedisPool=pool;
	}

	public void run() {
			try {
				jedis.setnx("player", clientName);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				jedisPool.returnResource(jedis);
			}
	}
}

