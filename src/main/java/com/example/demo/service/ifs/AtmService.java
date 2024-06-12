package com.example.demo.service.ifs;

import com.example.demo.vo.AtmResponse;

public interface AtmService {
	
	//
	public AtmResponse login(String account,String pwd);
	
	public AtmResponse addInfo(String account,String pwd); //()���a�J�b���K�X
	
	//�ˬd�b�K																			
	public AtmResponse getBalanceByAccount(String account,String pwd);//��ܾl�B�n���b����T

	public AtmResponse updatePwd(String account,String pwd,String oldPwd,String newPwd); //�ק�K�X��k

	//�s��deposit		int amount�s�ڪ��B
	public AtmResponse deposit(String account,String pwd,int amount);
	
	//����withdraw	int amount���ڪ��B
	public AtmResponse withdraw(String account,String pwd,int amount);

	
	
}
