package com.example.demo.entity;

			//Cat繼承Animal(此時Cat為子類別Animal為父類別)
public class Cat extends Animal {	//extends擴充(繼承關鍵字),繼承Animal
	

	public Cat() {
		super();
		System.out.println("Cat 建構方法");
	}
	
	@Override
	public void eat() {
		System.out.println(super.getName() + "Cat 吃太飽!!");
	}
	
	@Override
	public void sleep() {
		System.out.println(super.getName() + "Cat 沒睡飽!!");
	}
	
	public void barking() {
		System.out.println("Cat 正在叫!!");
	}
	
}
