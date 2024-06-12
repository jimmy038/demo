package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu") //menu�������Ʈw����menu
public class Menu {
	
	@Id					   //Id �������Ʈw��Pk
	@Column(name = "name") //Column��� Column�̭���name�������Ʈw��ƪ������W��
	private String name;
	
	@Column(name = "price")//Column��� Column�̭���name price�������Ʈw��ƪ���������
	private int price;
	
	public Menu() {
		super();
	}
	
	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
