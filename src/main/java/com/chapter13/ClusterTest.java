package com.chapter13;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.BinaryJedisCluster;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class ClusterTest {

	public static void main(String[] args) {
		
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("192.168.1.16", 10001));
		jedisClusterNodes.add(new HostAndPort("192.168.1.16", 10002));
		jedisClusterNodes.add(new HostAndPort("192.168.1.16", 10003));
		
		GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
		
//		JedisCluster jedis=new JedisCluster(jedisClusterNodes);
		
		BinaryJedisCluster jedis = new BinaryJedisCluster(jedisClusterNodes,1000,1000,1000,"123456",poolConfig);
		try {
//			jedis.set("apple", "macbook");
//			System.out.println(jedis.get("apple"));
			jedis.set("foo".getBytes(), "bar".getBytes());
			String msg=new String(jedis.get("foo".getBytes()));
			System.out.println(msg);
			jedis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
