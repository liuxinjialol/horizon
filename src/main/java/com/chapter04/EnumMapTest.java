package com.chapter04;

import java.util.*;

enum Season {
	SPRING, SUMMER, FALL, WINTER
}

public class EnumMapTest {
	public static void main(String[] args) {
		// 创建EnumMap对象，该EnumMap的所有key都是Season枚举类的枚举值
		EnumMap enumMap = new EnumMap(Season.class);
		enumMap.put(Season.SUMMER, "小荷才露尖尖角");
		enumMap.put(Season.SPRING, "满园春色关不住");
		System.out.println(enumMap);
	}
}
