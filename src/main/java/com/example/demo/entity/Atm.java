package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Entity就只是單純跟DB做的連結的資料而已
@Table(name = "atm")
public class Atm {
	
	@Id
	@Column(name = "account")	//帳號
	private String account;
	
	@Column(name = "password") //密碼
	private String pwd; 	   //程式碼不要寫password
	
	@Column(name = "balance") //
	private int balance; //int預設值0

	public Atm() {
		super();
	}

//	因int預設值0,所以建構方法只需要兩個參數account跟pwd,所以再生成一個只有兩個參數的建構方法
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
