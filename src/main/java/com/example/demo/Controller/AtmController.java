package com.example.demo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.RtnCode;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmRequest;
import com.example.demo.vo.AtmResponse;

@RestController
public class AtmController {

	@Autowired
	private AtmService atmService;
//						 							
	@GetMapping(value = "atm/login")
	public AtmResponse login(@RequestBody AtmRequest req, HttpSession session) {
		//
		if(session.getAttribute("account") != null) {
			return new AtmResponse(null, RtnCode.SUCCESSFUL);
		}
		AtmResponse res = atmService.login(req.getAccount(), req.getPwd());
		if(res.getRtnCode().getCode() == 200) {
			session.setAttribute("account", req.getAccount());//key值 value值
			session.setAttribute("password", req.getPwd());	  //key值 value值
			session.setMaxInactiveInterval(300); //設定session有效時間300秒為5分鐘(原預設30分鐘)
		}
		return res;
	}
	
//	��ؼg�k��	
//	@CacheEvict(cacheNames = "atm_login",key = "#req.account") //logout���R��,�R��key+value
//	public AtmResponse logout(@RequestBody AtmRequest req, HttpSession session) {
	@GetMapping(value = "atm/logout")      //url
	@CacheEvict(cacheNames = "atm_get_balance",key = "#account")
	public AtmResponse logout(@RequestParam String account, HttpSession session) {
		//讓session失效
		session.invalidate();
		return new AtmResponse(null, RtnCode.SUCCESSFUL); 
	}
	
	
	@PostMapping(value = "atm/add_info")
	public AtmResponse addInfo(@RequestBody AtmRequest req) {
		return atmService.addInfo(req.getAccount(), req.getPwd());
	}
		

	@GetMapping(value = "atm/get_balance") //讓使用者呼叫，兩個單字做底線串接
	public AtmResponse getBalanceByAccount(HttpSession session) { 
		//取出帳號及密碼 原回傳為物件，但接收型態是字串故需強轉為字串做回傳 (需先確定內部存放為字串)
		String account = (String)session.getAttribute("account"); 
		String pwd = (String)session.getAttribute("password");	  
		//強轉後檢查判斷帳號有存在的話直接回傳後存入帳密
		if(StringUtils.hasText(account)) { //�P�_�b���O�_����,�p�Gaccount���F�誺�ܴN��ܱK�X�]���F��,�]���O�@�P�s�J��
			return atmService.getBalanceByAccount(account, pwd);
		}
		//尚未登入否則回傳請先登入
		return new AtmResponse(null, RtnCode.PLEASE_LOGIN_FIRST);
	}
	
}
