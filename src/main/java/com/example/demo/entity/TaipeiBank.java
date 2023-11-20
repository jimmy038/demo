package com.example.demo.entity;

public class TaipeiBank {

	private String branch;	//屬性通常都會設定private
	
	private String user;
	
	private int balance = 1000;	//給予balance預設值為1000

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
	
	//	  	↓資料型態↓方法變數↓在條件判斷內帶入資料型態設定存入金額變數
	public int saving(int amount) {	//(存款)因為int包含負數所以需做防呆
		if(amount > 0) {			//如果存款金額大於0
			balance += amount;		//判斷如果存款金額有大於0去加到餘額內
		}
		return balance;				//最後回傳回去餘額
		}
	
//	  	   ↓資料型態↓方法變數↓在條件判斷內帶入資料型態設定提款金額變數
	public int withdarw(int amount) { 		   //(提款)
		if(amount > 0 && balance >= amount ) { //如果提款金額大於0 and餘額大於等於提款金額 
			balance -= amount;				   //判斷成立時提款金額減掉餘額
		}
		return balance;						   //最後回傳回去餘額
		}
}
