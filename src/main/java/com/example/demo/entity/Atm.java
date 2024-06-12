package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Entity�N�u�O��¸�DB�����s������ƦӤw
@Table(name = "atm")
public class Atm {
	
	@Id
	@Column(name = "account")	//�b��
	private String account;
	
	@Column(name = "password") //�K�X
	private String pwd; 	   //�{���X���n�gpassword
	
	@Column(name = "balance") //
	private int balance; //int�w�]��0

	public Atm() {
		super();
	}

//	�]int�w�]��0,�ҥH�غc��k�u�ݭn��ӰѼ�account��pwd,�ҥH�A�ͦ��@�ӥu����ӰѼƪ��غc��k
	public Atm(String account, String pwd) { 
		super();
		this.account = account;
		this.pwd = pwd;
	}
	
	public Atm(String account, String pwd, int balance) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.balance = balance;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}

}
