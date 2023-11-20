package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;
import com.example.demo.repository.AtmDao;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	private AtmDao atmDao;
	
	@Override //完整的方法 有回傳名稱有參數有邏輯及密碼加密,第一步都是檢查參數不能為null,空字串,空白 
	public AtmResponse addInfo(String account, String pwd) {
		//檢查字串是否為空,null,空白都是使用StringUtils.hasText,||為or符號
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
//			↓當參數帳密錯誤時要回復的錯誤訊息,先去new AtmResponse的類別,接著帶入格式錯誤的資訊
			return new AtmResponse(null, RtnCode.PARAM_ERROR); //null為atm,後面就回RtnCode
		}
		if (atmDao.existsById(account)) { //判斷帳號是否存在
			return new AtmResponse(null, RtnCode.ACCOUNT_EXISTED);
		}
		//BCryptPasswordEncoder密碼加密為密文
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Atm res = atmDao.save(new Atm(account, encoder.encode(pwd))); //因atm被AtmResponse包住,所以要先用dao.save,()內再去new Atm
		//不想回傳pwd,把密碼設定成空字串,所以帶入空字串	encoter.encode(pwd)密碼加密
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL); //資料驗證成功後存入,給予正確訊息
	}

	
	@Override //第一件事檢查參數
	public AtmResponse getBalanceByAccount(String account,String pwd) {
		if(!StringUtils.hasText(account)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);	
		}
		Optional<Atm> op = atmDao.findById(account);//findById為Jpa自己提供方法,他這邊被Optional包住
		if(op.isEmpty()) {	//判斷帳號是否存在
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		Atm res = op.get(); //從Optional把Atm這個物件取出先使用.get,get Atm這個物件
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//加密的密碼
		//要去比對加密的密碼,要用上面的變數encoter.matches(pwd, res.getPwed) pwd原本的密碼res.getPwd()加密後的密碼去做比對
		if(!encoder.matches(pwd, res.getPwd())) { //如果不match的話回復ACCOUNT_NOT_FOUND,因前面有!
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL); //成功存入的資訊
	}
	

	@Override //第一件事檢查參數,第二步檢查帳號存不存在,
	public AtmResponse updatePwd(String account, String pwd, String oldPwd, String newPwd) {
		if(!StringUtils.hasText(account) || !StringUtils.hasText(oldPwd) || !StringUtils.hasText(newPwd)) {
			return new AtmResponse(null,RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account);//findById為Jpa自己提供方法,他被Optional包住
		if(op.isEmpty()) {	//判斷帳號是否存在,如果為空會進入下面那行程式碼,回傳Account not found
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		Atm res = op.get(); //把Optional把被包起來的物件Atm取出使用.get,get Atm這個物件
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//加密的密碼
		//要去比對加密的密碼,要用上面的變數encoter.matches(pwd, res.getPwed) pwd原本的密碼res.getPwd()加密後的密碼去做比對
		if(!encoder.matches(oldPwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		res.setPwd(encoder.encode(newPwd));//要再對新密碼加密
		atmDao.save(res);//加密過後的資料整筆丟回資料庫存入
		res.setPwd("");	 //遮蔽密碼變成空字串
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	
	@Override //存款
	public AtmResponse deposit(String account, String pwd,int amount) {
//		!StringUtils.hasText判斷兩個條件其中一個如果為真時,就會回傳Param_error!!錯誤訊息
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)|| amount <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account);
		if(op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		Atm res = op.get(); //從Optional把Atm取出,使用.get,get Atm這個物件
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//加密的密碼
		//要去比對加密的密碼,要用上面的變數encoder.matches(pwd, res.getPwed) pwd原本的密碼res.getPwd()加密後的密碼去做比對
		if(!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		res.setBalance(res.getBalance()+amount);//要再對新密碼加密
		atmDao.save(res);//加密過後的資料整筆丟回資料庫存入
		res.setPwd("");	 //遮蔽密碼變成空字串
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	
	@Override	//提款
	public AtmResponse withdraw(String account, String pwd, int amount) {
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)|| amount <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account);
		if(op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		Atm res = op.get(); //從Optional把Atm取出先使用.get,get Atm這個物件
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//加密的密碼
		//去比對加密的密碼,要用上面的變數encoder.matches(pwd, res.getPwed) pwd原本的密碼res.getPwd()加密後的密碼去做比對
		if(!encoder.matches(pwd, res.getPwd())) {	//原本密碼比對加密後的密碼
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		//檢查餘額大於提款金額
		if(res.getBalance() < amount) {
			res.setPwd("");
			return new AtmResponse(null, RtnCode.INSUFFICIENT_BLANCE);	
		}
		res.setBalance(res.getBalance() - amount);
		atmDao.save(res);//加密過後的資料整筆丟回資料庫存入
		res.setPwd("");	 //遮蔽密碼變成空字串
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}



}
