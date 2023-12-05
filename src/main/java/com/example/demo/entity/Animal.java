package com.example.demo.entity;

public class Animal{	//一個父類別可以被多個子類別繼承
	
	private String name = "Fa";	//建立屬性,預設給值Fa
	
	
	public Animal() {	//產生預設建構方法
		super();
		System.out.println("Animal 建構方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println(this.name + " 正在吃!!");
	}
	
	public void sleep() {
		System.out.println(this.name + " 正在睡!!");
	}
	
}
