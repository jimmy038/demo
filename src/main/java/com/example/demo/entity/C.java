package com.example.demo.entity;

public class C { 	//抽出AB相同的屬性到C

	private String city;
	
	private String State;
	
	private String county;
	
	
	public C() {	//先建立預設建構方法,建構方法的方法名稱為類別名稱
		super();
	}

	//再建立帶有屬性的建構方法
	public C(String city, String state, String county) {
		super();
		this.city = city;
		State = state;
		this.county = county;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	
	
}
