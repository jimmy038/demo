package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtmRequest { //Request帶入兩個參數
	
	private String account;

	@JsonProperty("password") //@JsonProperty  Json格式
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
