package com.example.demo.entity;

//Bird�~��Animal(����Bird���l���OAnimal�������O) //�إ߰���� �V ��@ Runnable ����
public class Bird extends Animal implements Runnable{ //extends�X�R(�~������r),�~��Animal
	
	//HAS-A ���Y (�E�X(�]�t))(�S���Y���~��),��¬��F��ֵ{���X������,�⭫�ƪ��F���X���ͤ@�ӷs�����O
	//�]�ݭn���ݩʳQ�즳�����O(class)�ҩw�q�F,�ҥH��ݭn�o���ݩʮɥi�H������TaipeiBank���O�Өϥ�
	private TaipeiBank bank;	//�p���ݩ�TaipeiBank,�Y���ݭnTaipeiBank���T���ݩ�,�i�H�ϥ�TaipeiBank�ҩw�q���ݩ�	
	
//	private String branch;	
	
//	private String user;
	
//	private int balance = 1000;	
	
	
	public Bird() {
		super();
		System.out.println("Bird �غc��k");
	}	
	
// �~�Ӥ����O�ۦP���ݩʤΤ�k�i�H������or�R��
// �b�~�Ӥ���l���O�Τ����O���ۦP�W�٤�k��,�l���O�Y�n�Ƽg���s�w�q�ۤv����k��
	
	//����l���O���ۦP��k�W��,�l���O�惡��k���s�w�q�ۤv����@���e��{}�j�A��������@���e
	//@Override��:�Ƽg���N�� or ���s�w�q(�ߺD�g�W@Override)
	@Override 
	public void eat() {
		//super.�N��I�s�����O����k,�hget�����O(Animal)��getName��k
		System.out.println(super.getName() + "��Y�䪱!!");
	}
	
	@Override
	public void sleep() {
		//super.�N��I�s�����O����k,�hget�����O(Animal)��getName��k
		System.out.println(super.getName() + "��Y���!!");
	}
	
	public void flying() {
		//super.�N��I�s�����O����k,�hget�����O(Animal)��getName��k
		System.out.println(super.getName() + " ���b��!!"); 
	}

	//�إ߰���� �V ��@ Runnable ����
	@Override
	public void run() {
		for(int i = 1; i <= 5 ; i++) {
			System.out.println(getName() + "�ثe���b�]��" + i + "��");
		}
		System.out.println("���ڶ}����!!");
	}		
	
}
