package com.example.demo.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MealId implements Serializable{ //Serializable�ǦC��
//Meal�̭���ID���ݩʶ����@��class���޲z,����PK�Ѥ@�����O�������޲z
	
	private String name;
	
	private String cookingStyle;
	

	public MealId() { //�u�n���Ψ즳�Ѽƪ�,�w�]�غc��k�N�n����
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
