package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
	
	//直接宣告成private,在下面再使用encoder變數,就不用重新new
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private AtmDao atmDao;
	
	//		   ↓要對方法暫存資料,cacheNames等同value↓對應到()內的account變數,	unless(排除)排除200之外,反之只存200的
	@Override //寫Session,Session是儲存在伺服器端(Server)的暫存資料
	public AtmResponse login(String account, String pwd) {
//		↓此行檢查傳入的帳號和密碼是否為空或者沒有文字（空白）。如果其中任何一個為空或沒有文字，返回一個代表參數錯誤的AtmResponse 物件內使用的RtnCode.PARAM_ERROR這個代碼。		
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
//			↓當參數帳密錯誤時要回復的錯誤訊息,先去new AtmResponse的類別(物件),再帶入RtnCode內的格式錯誤的資訊
			return new AtmResponse(null, RtnCode.PARAM_ERROR); //null為atm,後面就回RtnCode
		}
//		↓在資料庫中尋找指定帳號（account）的 ATM 資料。
		Optional<Atm> op = atmDao.findById(account); 
//		↓如果在資料庫中找不到帳號，會返回一個代表帳號不存在的AtmResponse物件，用RtnCode內的ACCOUNT_NOT_FOUND這個代碼。		
		if(op.isEmpty()) { 
			return new AtmResponse(null,RtnCode.ACCOUNT_NOT_FOUND); 
		}
//		↓如果找到了帳號，會檢查傳入的密碼是否與資料庫中該帳號的加密密碼匹配。使用encoder，並比對傳入的密碼與資料庫中的加密密碼。如果不匹配，則返回一個代表登入錯誤的AtmResponse物件，使用RtnCode.LOGIN_ERROR 這個代碼。				
		if(!encoder.matches(pwd, op.get().getPwd())) {
			return new AtmResponse(null,RtnCode.LOGIN_ERROR);
		}
//		↓如果帳號和密碼驗證都成功，返回一個代表登入成功的AtmResponse物件，使用RtnCode.SUCCESSFUL這個代碼。		
		return new AtmResponse(null,RtnCode.SUCCESSFUL);
	}
	
	
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
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Atm res = atmDao.save(new Atm(account, encoder.encode(pwd))); //因atm被AtmResponse包住,所以要先用dao.save,()內再去new Atm
		//不想回傳pwd,把密碼設定成空字串,所以帶入空字串	encoter.encode(pwd)密碼加密
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL); //資料驗證成功後存入,給予正確訊息
	}

	@Cacheable(cacheNames = "atm_get_balance",key = "#account", unless = "#result.rtnCode.code != 200")	
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
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//加密的密碼
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
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//加密的密碼
		//要去比對加密的密碼,要用上面的變數encoder.matches(pwd, res.getPwed) pwd原本的密碼res.getPwd()加密後的密碼去做比對
		if(!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		res.setBalance(res.getBalance()+ amount);//要再對新密碼加密
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
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//加密的密碼
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
