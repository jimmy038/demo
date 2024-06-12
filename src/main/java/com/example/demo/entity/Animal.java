package com.example.demo.entity;

public class Animal{	//�@�Ӥ����O�i�H�Q�h�Ӥl���O�~��
	
	private String name = "Fa";	//�إ��ݩ�,�w�]����Fa
	
	
	public Animal() {	//���͹w�]�غc��k
		super();
		System.out.println("Animal �غc��k");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println(this.name + " ���b�Y!!");
	}
	
	public void sleep() {
		System.out.println(this.name + " ���b��!!");
	}
	
}
