package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

			//Dog���O,��@(implements)����(RunService)
public class Dog implements RunService{ // public(�Q�ϥΪ��v���̤j)��k�����ܼƤ���[�v��

	private String name = "Apple"; // private�p��(�Q�ϥΪ��v���̤p),�ݩʫᵹ�������w�]��,�b���O���U���ܼƺ٬��ݩ�

	private String color; // �ݩʤ������}���n��O

	private int age; // �ݩʼg���|���ݩʲ���get set,�ݩʳ]���p���g���ݴ��Ѥ�k�ѧO�H�ϥ�
	
//	public Dog() {	//�w�]�غc��k �v��(public) ���O�W��(Dog)
//	
//	}
	
					//��k�W�٦P���O�W��Dog,�S�����󪺦^�ǭȫ��A
	public Dog() {	//�ϥ�Source���͹w�]�غc��k,�I�˼ƲĤG��Generate
		super();	//super()�Φb�~�� �l���O�I�s�����O�ϥ�super
	}
				
	//�u�n�ͦ��a���ݩ�(�Ѽ�)���غc��k�W�����w�]�غc��k�@�w�n����
	public Dog(String name, String color, int age) { //�a���ݩ�(�Ѽ�)���غc��k
	super();
	this.name = name;
	this.color = color;
	this.age = age;
	}

	public String getName() {	//�H�U��k�����}
		return name;
	}

	public void setName(String name) {	//��k����void���ݭnreturn,(���Ѽ�)
		this.name = name; //this.�����O�o��class���ODog
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setAttributes(String name,String color,int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}
	
	public void setAttributes() {
		System.out.println("===========================");
	}
	
	public  static void setAttributes2() {
		System.out.println("===========================");
	}

	@Override	//����L�CDog���O�Iadd���ͪ��@�ӥi�H���s�w�q����k
	public void run() {
		System.out.println("����b�b�]");
	}
}
