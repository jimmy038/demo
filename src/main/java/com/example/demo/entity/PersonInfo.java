package com.example.demo.entity; //entity為資料庫與程式之間的媒介

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	//讓spring boot做託管(託付管理),使用@Entity
@Table(name = "person_info") //@Table對應到資料庫的表格
public class PersonInfo {
	
	@Id	 //id為PK,PK為唯一值	ctrl + shift + o (產生)import視窗
	@Column(name = "id") 	//屬性與資料庫的欄位連動@Column(欄)
	private String id;
	
	@Column(name = "name")	//屬性與資料庫的欄位連動@Column(欄)
	private String name;
	
	@Column(name = "age")	//屬性與資料庫的欄位連動@Column(欄)
	private int age;
	
	@Column(name = "city")	//屬性與資料庫的欄位連動@Column(欄)
	private String city;

	public PersonInfo() {
		super();
	}

	public PersonInfo(String id, String name, int age, String city) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
