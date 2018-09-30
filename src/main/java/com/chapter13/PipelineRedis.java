package com.chapter13;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

public class PipelineRedis {

	public static void main(String[] args) {

		JedisPool pool = null;
		// String ip = "192.168.1.62";
		String ip = "127.0.0.1";
		int port = 6379;
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(10000);
		config.setMaxWaitMillis(1000 * 100);
		config.setTestOnBorrow(true);
		pool = new JedisPool(config, ip, port, 100000);
		Jedis jedis = pool.getResource();

		try {

			System.out.println(jedis.set("name1","tommy1"));
			System.out.println(jedis.set("name2","tommy2"));
			System.out.println(jedis.set("name3","tommy3"));
			System.out.println(jedis.set("name4","tommy4"));
			
			Pipeline pipeline=jedis.pipelined();
			pipeline.del("name1");
			pipeline.del("name2");
			pipeline.del("name3");
			pipeline.del("name4");
			pipeline.del("name5");
			List<Object> list=pipeline.syncAndReturnAll();
			for(Object obj:list) {
				System.out.println(obj);
			}

		} catch (Exception e) {

		} finally {
			if(jedis!=null) {
				jedis.close();
			}
			pool.close();
		}

	}
}

