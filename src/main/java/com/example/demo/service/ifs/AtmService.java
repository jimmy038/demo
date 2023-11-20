package com.example.demo.service.ifs;

import com.example.demo.vo.AtmResponse;

public interface AtmService {

	public AtmResponse addInfo(String account,String pwd); //()←帶入帳號密碼
	
	//檢查帳密																			
	public AtmResponse getBalanceByAccount(String account,String pwd);//顯示餘額要有帳號資訊

	public AtmResponse updatePwd(String account,String pwd,String oldPwd,String newPwd); //修改密碼方法

	//存款deposit		int amount存款金額
	public AtmResponse deposit(String account,String pwd,int amount);
	
	//提款withdraw	int amount提款金額
	public AtmResponse withdraw(String account,String pwd,int amount);

	
	
}
