package com.example.demo.entity;

public class C { 	//��XAB�ۦP���ݩʨ�C

	private String city;
	
	private String State;
	
	private String county;
	
	
	public C() {	//���إ߹w�]�غc��k,�غc��k����k�W�٬����O�W��
		super();
	}

	//�A�إ߱a���ݩʪ��غc��k
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
