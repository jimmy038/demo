package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtmRequest { //Request(�ШD)�q�`�u�|����get&set
	
//	��q�~���i�Ӫ��ШD�]�@�]�ܦ��@��Request
	private String account;
	
	@JsonProperty("password") //�n���~�����ݭn�ϥ�Json�榡,�n�[�W@JsonProperty 
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
