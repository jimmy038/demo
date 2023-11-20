package com.example.demo.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MealId implements Serializable{ //Serializable序列化
//Meal裡面有ID的屬性集中一個class做管理,把兩個PK由一個類別做集中管理
	
	private String name;
	
	private String cookingStyle;
	

	public MealId() { //只要有用到有參數的,預設建構方法就要產生
		super();
	}
	
	
	public MealId(String name, String cookingStyle) {
		super();
		this.name = name;
		this.cookingStyle = cookingStyle;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCookingStyle() {
		return cookingStyle;
	}

	public void setCookingStyle(String cookingStyle) {
		this.cookingStyle = cookingStyle;
	}

}
