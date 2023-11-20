package com.example.demo.entity;

public class A1 extends C { //A1繼承C類別
	
//	private String city;
//	
//	private String State;
//	
//	private String county;
	
	//屬性若為私有的建立完後都需要建立get跟set方法
	private C c = new C(); //給予類別C預設值,new 類別C 
	//沒關係的繼承HAS-A (聚合)為沒有使用extends,為沒關係的繼承
	
	private String address;	//屬性若為私有的建立完後都需要建立get跟set方法

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
