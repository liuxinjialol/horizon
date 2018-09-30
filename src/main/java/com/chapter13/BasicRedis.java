package com.chapter13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

public class BasicRedis {

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
		
		System.out.println(jedis.info());

		try {

			// System.out.println(jedis.info());
			System.out.println("-------------string------------------");
			jedis.del("foo");
			System.out.println(jedis.setnx("foo", "bar"));
			System.out.println(jedis.set("foo", "bar"));
			System.out.println(jedis.setnx("foo", "bar"));
			System.out.println(jedis.get("foo"));

			System.out.println("-------------list----------------");

			jedis.del("foolist");
			jedis.lpush("foolist", "a");
			jedis.lpush("foolist", "b");
			jedis.lpush("foolist", "c");
			jedis.lpush("foolist", "d");
			jedis.lpush("foolist", "e");
			jedis.lpush("foolist", "f");
			jedis.lpush("foolist", "g");
			System.out.println(jedis.lrange("foolist", 0, 100));
			System.out.println(jedis.lpop("foolist"));
			System.out.println(jedis.rpop("foolist"));

			System.out.println("------------map-----------------");

			Map<String, String> hash = new HashMap<>();
			hash.put("f1", "1");
			hash.put("f2", "2");
			hash.put("f3", "3");
			jedis.hmset("foohash", hash);
			jedis.hset("foohash", "f4", "4");

			System.out.println(jedis.hget("foohash", "f3"));
			System.out.println(jedis.hmget("foohash", "f1", "f2"));
			System.out.println(jedis.hgetAll("foohash"));

			System.out.println("------------set-----------------");
			jedis.sadd("fooset", "s1");
			jedis.sadd("fooset", "s2");
			jedis.sadd("fooset", "s3");
			jedis.srem("fooset", "s1");
			System.out.println(jedis.smembers("fooset"));

			System.out.println("------------zset-----------------");
			jedis.zadd("foozset", 5.1, "s1");
			jedis.zadd("foozset", 2.2, "s2");
			jedis.zadd("foozset", 3.3, "s3");
			jedis.zrem("foozset", "s2");
			System.out.println(jedis.zrange("foozset", 0, 3));

			System.out.println("------------geo-----------------");

			jedis.geoadd("tongzhou", 116.6825362443, 39.9263682844, "K2清水湾");
			jedis.geoadd("tongzhou", 116.6847082443, 39.9283542844, "耿庄家园");
			jedis.geoadd("tongzhou", 116.6879605563, 39.9287187221, "龙旺庄小区");
			jedis.geoadd("tongzhou", 116.6903882763, 39.9379073762, "龙旺庄宾馆");
			jedis.geoadd("tongzhou", 116.6833482443, 39.9348042844, "友谊新华医院");
			jedis.geoadd("tongzhou", 116.7351920000, 40.0468700000, "南河村");

			List<GeoRadiusResponse> list = jedis.georadius("tongzhou", 116.6825362443, 39.9263682844, 900, GeoUnit.M);
			for (GeoRadiusResponse item : list) {
				System.out.println(item.getMemberByString());
			}

			System.out.println(jedis.geodist("tongzhou", "K2清水湾", "耿庄家园", GeoUnit.M));
			System.out.println(jedis.geodist("tongzhou", "K2清水湾", "友谊新华医院", GeoUnit.M));
			System.out.println(jedis.geodist("tongzhou", "K2清水湾", "南河村", GeoUnit.KM));

			System.out.println("------------pub/sub-----------------");

			
			Thread subThread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Jedis subjedis = new Jedis("127.0.0.1", 6379);
						Subscriber ss = new Subscriber();
						subjedis.subscribe(ss, "chatroom");

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			});
			subThread.start();
			
			
			Jedis pubjedis = pool.getResource();
			Thread.sleep(5000);  
			pubjedis.publish("chatroom", "hello,world");
			int i=0;  
	        while(i < 10){  
	            String message=UUID.randomUUID().toString();
	            pubjedis.publish("chatroom", message);
	            i++;  
	            Thread.sleep(1000);  
	        }  
			
			

		} catch (Exception e) {

		} finally {
			pool.returnResource(jedis);
			pool.close();
		}

	}

}

class Subscriber extends JedisPubSub {

	@Override
	public void onMessage(String channel, String message) {
		System.out.println("message is " + message);
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		System.out.println("message receive:" + message + ",channel:" + channel + "..." + System.currentTimeMillis());
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
	}

	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
	}
}
