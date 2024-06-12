package com.example.demo.entity; //entity����Ʈw�P�{���������C��

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	//��spring boot���U��(�U�I�޲z),�ϥ�@Entity
@Table(name = "person_info") //@Table�������Ʈw�����
public class PersonInfo {
	
	@Id	 //id��PK,PK���ߤ@��	ctrl + shift + o (����)import����
	@Column(name = "id") 	//�ݩʻP��Ʈw�����s��@Column(��)
	private String id;
	
	@Column(name = "name")	//�ݩʻP��Ʈw�����s��@Column(��)
	private String name;
	
	@Column(name = "age")	//�ݩʻP��Ʈw�����s��@Column(��)
	private int age;
	
	@Column(name = "city")	//�ݩʻP��Ʈw�����s��@Column(��)
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
