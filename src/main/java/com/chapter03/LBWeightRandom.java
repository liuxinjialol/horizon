package com.chapter03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author admin
 *加权随机
 */


public class LBWeightRandom {
	
	static Map<String,Integer> serverWeigthMap =new HashMap<String,Integer>();
	
	static {
		serverWeigthMap.put("192.168.1.11", 1);
		serverWeigthMap.put("192.168.1.12", 1);
		serverWeigthMap.put("192.168.1.13", 2);
		serverWeigthMap.put("192.168.1.14", 4);
		serverWeigthMap.put("192.168.1.15", 5);
		serverWeigthMap.put("192.168.1.16", 1);
		serverWeigthMap.put("192.168.1.17", 2);
		serverWeigthMap.put("192.168.1.18", 3);
		serverWeigthMap.put("192.168.1.19", 3);
	}
	
	Integer pos=0;
	
	public String random() {
		Map<String,Integer> serverMap =new HashMap<String,Integer>();
		serverMap.putAll(serverWeigthMap);
		Set<String> keySet=serverMap.keySet();
		Iterator<String> it =keySet.iterator();
		ArrayList<String> serverList=new ArrayList<String>();
		while(it.hasNext()) {
			String server=it.next();
			Integer weight=serverMap.get(server);
			for(int i=0;i<weight;i++) {
				serverList.add(server);
			}
		}
		Random rand=new Random();
		int pos=rand.nextInt(serverList.size());
		String server=serverList.get(pos);
		return server;
	}
	
	public static void main(String[] args) {
		LBWeightRandom test =new LBWeightRandom();
		for (int i=0;i<20;i++) {
			String ip=test.random();
			System.out.println("ip="+ip);
		}
	}

}
