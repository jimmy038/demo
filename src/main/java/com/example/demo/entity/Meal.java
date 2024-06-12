package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "meal")
@IdClass(value = MealId.class)//�i�D��Ʈw���PK ID�޲z��class
public class Meal {

	@Id					   //Id �������Ʈw��Pk
	@Column(name = "name") //Column��� Column�̭���name�������Ʈw��ƪ������W��
	private String name;
	
	@Id
	@Column(name = "cooking_style")//Column�̭���name,�������Ʈw��ƪ���cooking_style
	private String cookingStyle;
	
	@Column(name = "price")//Column�̭���name,�������Ʈw��ƪ���������price
	private int price;

	
	public Meal() {
		super();	
	}

	public Meal(String name, String cooking_style, int price) {
		super();
		this.name = name;
		this.cookingStyle = cooking_style;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCooking_style() {
		return cookingStyle;
	}

	public void setCooking_style(String cooking_style) {
		this.cookingStyle = cooking_style;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
