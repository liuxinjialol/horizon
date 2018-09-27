package com.chapter03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author admin
 *轮询
 */


public class LBRobin {
	
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
	
	public String roundRobin() {
		Map<String,Integer> serverMap =new HashMap<String,Integer>();
		serverMap.putAll(serverWeigthMap);
		Set<String> keySet=serverMap.keySet();
		ArrayList<String> keyList=new ArrayList<String>();
		keyList.addAll(keySet);
		String server=null;
		synchronized(pos) {
			if(pos>=keySet.size()) {
				pos=0;
			}
			server=keyList.get(pos);
			pos++;
		}
		return server;
	}
	
	public static void main(String[] args) {
		LBRobin test =new LBRobin();
		for (int i=0;i<20;i++) {
			String ip=test.roundRobin();
			System.out.println("ip="+ip);
		}
	}

}
