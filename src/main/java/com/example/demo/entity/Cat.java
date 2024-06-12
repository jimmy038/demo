package com.example.demo.entity;

			//Cat�~��Animal(����Cat���l���OAnimal�������O)
public class Cat extends Animal {	//extends�X�R(�~������r),�~��Animal
	

	public Cat() {
		super();
		System.out.println("Cat �غc��k");
	}
	
	@Override
	public void eat() {
		System.out.println(super.getName() + "Cat �Y�ӹ�!!");
	}
	
	@Override
	public void sleep() {
		System.out.println(super.getName() + "Cat �S�ι�!!");
	}
	
	public void barking() {
		System.out.println("Cat ���b�s!!");
	}
	
}
