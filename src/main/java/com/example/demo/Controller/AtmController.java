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

@RestController //controller都要先加@RestController 
public class AtmController {

	@Autowired 
	private AtmService atmService;
//														  session暫存帳密	
	@GetMapping(value = "atm/login") //給予路徑使用Get       ↓在參數內放入Session 
	public AtmResponse login(@RequestBody AtmRequest req, HttpSession session) {
		if(session.getAttribute("account") != null) {
			return new AtmResponse(null, RtnCode.SUCCESSFUL);
		}
		AtmResponse res = atmService.login(req.getAccount(), req.getPwd());
		if(res.getRtnCode().getCode() == 200) {
			//透過 setAttribute(String, Object) 設定 key-value
			session.setAttribute("account", req.getAccount());//存帳號
			session.setAttribute("password", req.getPwd());	  //存密碼
			session.setMaxInactiveInterval(300); //設定session有效時間為300秒,session預設單位為秒,(預設有效時間為30分)
		}
		return res;
	}
	
//	兩種寫法↓	
//	@CacheEvict(cacheNames = "atm_login",key = "#req.account") //logout的刪除,刪除key+value
//	public AtmResponse logout(@RequestBody AtmRequest req, HttpSession session) {
	@GetMapping(value = "atm/logout") //url:localhost:8080/atm/logout?account=值     
	@CacheEvict(cacheNames = "atm_get_balance",key = "#account")
	public AtmResponse logout(@RequestParam String account, HttpSession session) {
		//讓session失效
		session.invalidate();
		//回傳一個新的AtmResponse
		return new AtmResponse(null, RtnCode.SUCCESSFUL); 
	}
	
	
	@PostMapping(value = "atm/add_info")
	public AtmResponse addInfo(@RequestBody AtmRequest req) {
		return atmService.addInfo(req.getAccount(), req.getPwd());
	}
		
//	若要取得餘額就要先登入成功才會有帳密,才有辦法使用getBalance的方法
	@GetMapping(value = "atm/get_balance") //給使用者呼叫寫的格式用底線串接
	public AtmResponse getBalanceByAccount(HttpSession session) {
		String account= (String)session.getAttribute("account"); //在這個物件前面的(String)為強制轉型寫法;
		String pwd = (String)session.getAttribute("password");	//在這個物件前面的(String)為強制轉型寫法;
		//↓在上面取出帳密後再去做判斷
		if(StringUtils.hasText(account)) { //判斷帳號是否為空,如果account有東西的話就表示密碼也有東西,因為是一同存入的
			return atmService.getBalanceByAccount(account, pwd);
		}
		//若沒進到if判斷式,就為沒有帳號就會要求你先登入
		return new AtmResponse(null, RtnCode.PLEASE_LOGIN_FIRST);
	}
	
}
