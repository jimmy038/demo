package com.example.demo.service.impl;

import java.util.List;
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
	
	//額外抽出變成私有方法
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private AtmDao atmDao;
	
	@Override //�gSession,Session�O�x�s�b���A����(Server)���Ȧs���
	public AtmResponse login(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR); //null��atm,�᭱�N�^RtnCode
		}
		Optional<Atm> op = atmDao.findById(account); 
		if(op.isEmpty()) { 
			return new AtmResponse(null,RtnCode.ACCOUNT_NOT_FOUND); 
		}
		if(!encoder.matches(pwd, op.get().getPwd())) {
			return new AtmResponse(null,RtnCode.LOGIN_ERROR);
		}
		return new AtmResponse(null,RtnCode.SUCCESSFUL);
	}
	
	
	@Override //���㪺��k ���^�ǦW�٦��ѼƦ��޿�αK�X�[�K,�Ĥ@�B���O�ˬd�ѼƤ��ରnull,�Ŧr��,�ť� 
	public AtmResponse addInfo(String account, String pwd) {
		//�ˬd�r��O�_����,null,�ťճ��O�ϥ�StringUtils.hasText,||��or�Ÿ�
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
//			����ѼƱb�K���~�ɭn�^�_�����~�T��,���hnew AtmResponse�����O,���۱a�J�榡���~����T
			return new AtmResponse(null, RtnCode.PARAM_ERROR); //null��atm,�᭱�N�^RtnCode
		}
		if (atmDao.existsById(account)) { //�P�_�b���O�_�s�b
			return new AtmResponse(null, RtnCode.ACCOUNT_EXISTED);
		}
		Atm res = atmDao.save(new Atm(account, encoder.encode(pwd))); //�]atm�QAtmResponse�]��,�ҥH�n����dao.save,()���A�hnew Atm
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL); //������Ҧ��\��s�J,�������T�T��
	}

	@Cacheable(cacheNames = "atm_get_balance",key = "#account", unless = "#result.rtnCode.code != 200")	
	@Override 
	public AtmResponse getBalanceByAccount(String account,String pwd) {
		if(!StringUtils.hasText(account)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);	
		}
		Optional<Atm> op = atmDao.findById(account);
		if(op.isEmpty()) {	//�P�_�b���O�_�s�b
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		Atm res = op.get(); //�qOptional��Atm�o�Ӫ�����X���ϥ�.get,get Atm�o�Ӫ���
		if(!encoder.matches(pwd, res.getPwd())) { 
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL); 
	}
	

	@Override //�Ĥ@����ˬd�Ѽ�,�ĤG�B�ˬd�b���s���s�b,
	public AtmResponse updatePwd(String account, String pwd, String oldPwd, String newPwd) {
		if(!StringUtils.hasText(account) || !StringUtils.hasText(oldPwd) || !StringUtils.hasText(newPwd)) {
			return new AtmResponse(null,RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account);//findById��Jpa�ۤv���Ѥ�k,�L�QOptional�]��
		if(op.isEmpty()) {	//�P�_�b���O�_�s�b,�p�G���ŷ|�i�J�U������{���X,�^��Account not found
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		Atm res = op.get(); //��Optional��Q�]�_�Ӫ�����Atm���X�ϥ�.get,get Atm�o�Ӫ���
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//�[�K���K�X
		//�n�h���[�K���K�X,�n�ΤW�����ܼ�encoter.matches(pwd, res.getPwed) pwd�쥻���K�Xres.getPwd()�[�K�᪺�K�X�h�����
		if(!encoder.matches(oldPwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		res.setPwd(encoder.encode(newPwd));//�n�A��s�K�X�[�K
		atmDao.save(res);//�[�K�L�᪺��ƾ㵧��^��Ʈw�s�J
		res.setPwd("");	 //�B���K�X�ܦ��Ŧr��
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	
	@Override //�s��
	public AtmResponse deposit(String account, String pwd,int amount) {
//		!StringUtils.hasText�P�_��ӱ���䤤�@�Ӧp�G���u��,�N�|�^��Param_error!!���~�T��
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)|| amount <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account);
		if(op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		Atm res = op.get(); //�qOptional��Atm���X,�ϥ�.get,get Atm�o�Ӫ���
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//�[�K���K�X
		//�n�h���[�K���K�X,�n�ΤW�����ܼ�encoder.matches(pwd, res.getPwed) pwd�쥻���K�Xres.getPwd()�[�K�᪺�K�X�h�����
		if(!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		res.setBalance(res.getBalance()+ amount);//�n�A��s�K�X�[�K
		atmDao.save(res);//�[�K�L�᪺��ƾ㵧��^��Ʈw�s�J
		res.setPwd("");	 //�B���K�X�ܦ��Ŧr��
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	
	@Override	//����
	public AtmResponse withdraw(String account, String pwd, int amount) {
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)|| amount <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account);
		if(op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		Atm res = op.get(); //�qOptional��Atm���X���ϥ�.get,get Atm�o�Ӫ���
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//�[�K���K�X
		//�h���[�K���K�X,�n�ΤW�����ܼ�encoder.matches(pwd, res.getPwed) pwd�쥻���K�Xres.getPwd()�[�K�᪺�K�X�h�����
		if(!encoder.matches(pwd, res.getPwd())) {	//�쥻�K�X���[�K�᪺�K�X
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);	
		}
		//�ˬd�l�B�j�󴣴ڪ��B
		if(res.getBalance() < amount) {
			res.setPwd("");
			return new AtmResponse(null, RtnCode.INSUFFICIENT_BLANCE);	
		}
		res.setBalance(res.getBalance() - amount);
		atmDao.save(res);//�[�K�L�᪺��ƾ㵧��^��Ʈw�s�J
		res.setPwd("");	 //�B���K�X�ܦ��Ŧr��
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}


}
