package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtmRequest { //Request(請求)通常只會產生get&set
	
//	把從外面進來的請求包一包變成一個Request
	private String account;
	
	@JsonProperty("password") //要讓外面的看要使用Json格式,要加上@JsonProperty 
	private String pwd;

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
	
	
	
}
