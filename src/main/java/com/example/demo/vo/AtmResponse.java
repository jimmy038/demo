package com.example.demo.vo;	//在VO這邊放入Response(回應),VO(Value object)主要用於資料的包裝

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;

// 						概念與繼承的has a相同,一個類別內會包含一個至多個的類別
public class AtmResponse {	//Response回應 ,request請求 通常會把這兩個放在同一個資料夾(Package)底下
	
	
	private Atm atm; //如果在實作那邊成功了要回應atm裡面的東西,所以要把Atm拉進來
	
	private RtnCode rtnCode; //會從AtmResponse取得這個RtnCode,取得之後再去RtnCode裡面去get code跟message

	
	public AtmResponse() {
		super();
	}

	
	public RtnCode getRtnCode() {
		return rtnCode;
	}


	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
	
//  把RtnCode拉進來之後因code跟message在RtnCode裡面,所以這邊的建構方法只有atm跟RtnCode
	public AtmResponse(Atm atm, RtnCode rtnCode) {
		super();
		this.atm = atm;
		this.rtnCode = rtnCode;
	}

	public Atm getAtm() {
		return atm;
	}

	public void setAtm(Atm atm) {
		this.atm = atm;
	}
	
	
}
