package com.example.demo.entity;

public class TaipeiBank {

	private String branch;	//�ݩʳq�`���|�]�wprivate
	
	private String user;
	
	private int balance = 1000;	//����balance�w�]�Ȭ�1000

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//	  	����ƫ��A����k�ܼơ��b����P�_���a�J��ƫ��A�]�w�s�J���B�ܼ�
	public int saving(int amount) {	//(�s��)�]��int�]�t�t�ƩҥH�ݰ����b
		if(amount > 0) {			//�p�G�s�ڪ��B�j��0
			balance += amount;		//�P�_�p�G�s�ڪ��B���j��0�h�[��l�B��
		}
		return balance;				//�̫�^�Ǧ^�h�l�B
		}
	
//	  	   ����ƫ��A����k�ܼơ��b����P�_���a�J��ƫ��A�]�w���ڪ��B�ܼ�
	public int withdarw(int amount) { 		   //(����)
		if(amount > 0 && balance >= amount ) { //�p�G���ڪ��B�j��0 and�l�B�j�󵥩󴣴ڪ��B 
			balance -= amount;				   //�P�_���߮ɴ��ڪ��B��l�B
		}
		return balance;						   //�̫�^�Ǧ^�h�l�B
		}
}
