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

@RestController //controller���n���[@RestController 
public class AtmController {

	@Autowired 
	private AtmService atmService;
//														  session�Ȧs�b�K	
	@GetMapping(value = "atm/login") //�������|�ϥ�Get       ���b�ѼƤ���JSession 
	public AtmResponse login(@RequestBody AtmRequest req, HttpSession session) {
		if(session.getAttribute("account") != null) {
			return new AtmResponse(null, RtnCode.SUCCESSFUL);
		}
		AtmResponse res = atmService.login(req.getAccount(), req.getPwd());
		if(res.getRtnCode().getCode() == 200) {
			//�z�L setAttribute(String, Object) �]�w key-value
			session.setAttribute("account", req.getAccount());//�s�b��
			session.setAttribute("password", req.getPwd());	  //�s�K�X
			session.setMaxInactiveInterval(300); //�]�wsession���Įɶ���300��,session�w�]��쬰��,(�w�]���Įɶ���30��)
		}
		return res;
	}
	
//	��ؼg�k��	
//	@CacheEvict(cacheNames = "atm_login",key = "#req.account") //logout���R��,�R��key+value
//	public AtmResponse logout(@RequestBody AtmRequest req, HttpSession session) {
	@GetMapping(value = "atm/logout") //url:localhost:8080/atm/logout?account=��     
	@CacheEvict(cacheNames = "atm_get_balance",key = "#account")
	public AtmResponse logout(@RequestParam String account, HttpSession session) {
		//��session����
		session.invalidate();
		//�^�Ǥ@�ӷs��AtmResponse
		return new AtmResponse(null, RtnCode.SUCCESSFUL); 
	}
	
	
	@PostMapping(value = "atm/add_info")
	public AtmResponse addInfo(@RequestBody AtmRequest req) {
		return atmService.addInfo(req.getAccount(), req.getPwd());
	}
		
//	�Y�n���o�l�B�N�n���n�J���\�~�|���b�K,�~����k�ϥ�getBalance����k
	@GetMapping(value = "atm/get_balance") //���ϥΪ̩I�s�g���榡�Ω��u�걵
	public AtmResponse getBalanceByAccount(HttpSession session) {
		String account= (String)session.getAttribute("account"); //�b�o�Ӫ���e����(String)���j���૬�g�k;
		String pwd = (String)session.getAttribute("password");	//�b�o�Ӫ���e����(String)���j���૬�g�k;
		//���b�W�����X�b�K��A�h���P�_
		if(StringUtils.hasText(account)) { //�P�_�b���O�_����,�p�Gaccount���F�誺�ܴN��ܱK�X�]���F��,�]���O�@�P�s�J��
			return atmService.getBalanceByAccount(account, pwd);
		}
		//�Y�S�i��if�P�_��,�N���S���b���N�|�n�D�A���n�J
		return new AtmResponse(null, RtnCode.PLEASE_LOGIN_FIRST);
	}
	
}
