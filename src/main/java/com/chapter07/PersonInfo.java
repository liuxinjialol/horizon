package com.chapter07;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonInfo {
	
	public static String nation="china";
	
	private String name;
	
	private int age;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date birthday;
	

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public static String getNation() {
		return nation;
	}

	public static void setNation(String nation) {
		PersonInfo.nation = nation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public static void main(String[] args) throws Exception{
		
		System.out.println(PersonInfo.getNation());
		
		PersonInfo p1=new PersonInfo();
		
		p1.setName("tommy");
		p1.setBirthday(new Date());
		
		System.out.println(p1.getNation());
		
		System.out.println(p1.nation);
		
		PersonInfo p2=new PersonInfo();
		
		System.out.println(p2.getNation());
		
		System.out.println(p2.nation);
		
		p2.nation="usa";
		
		System.out.println(p2.nation);
		
		System.out.println(p2.getNation());
		
		System.out.println(p1.nation);
		
		System.out.println(p1.getNation());
		
		System.out.println(PersonInfo.getNation());
		
		System.out.println(JsonUtil.json(p1));
		
		System.out.println(JsonUtil.json(p2));
		
	}
	

}
