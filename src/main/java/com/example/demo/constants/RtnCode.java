package com.example.demo.constants; //constants常數常量的意思

//enum格式本身為列舉所以都先需寫SUCCESSFUL(200,"OK!")成功或是錯誤的訊息出來
//錯誤訊息都會寫在這邊	RtnCode為returnCode的意思
public enum RtnCode { //先建立package再建立enum(列舉),取名RtnCode,這邊放錯誤訊息,將錯誤訊息條件式列出
	
//	SUCCESSFUL為成功,()內的查HTTP狀態碼,主要用200,400,401,403,404, 200為成功,固定的,權限有相關的401&403,404固定就為找不到,剩下歸類到400
	SUCCESSFUL(200,"SUCCESSFUL!!"),//  			在逗號後面加上註解符號有斷行的用意
	PARAM_ERROR(400,"Param_error!!"),//  Param_error參數錯誤的意思 通常字串內容為前面訊息的小寫
	ACCOUNT_EXISTED(400,"Account existed!!"),//  Account existed帳戶已存在
	ACCOUNT_NOT_FOUND(404,"Account not found!!"),//  Account not found找不到此帳戶
	INSUFFICIENT_BLANCE(400,"Insufficient Blance!!"), //  Insufficient_Blance餘額不足
	LOGIN_ERROR(400,"Login error!!"), //
	PLEASE_LOGIN_FIRST(400,"please Login First!!")
	;
	
	private int code; //這邊的code指的是代碼,回傳一個代碼
	
	private String message;

	private RtnCode(int code, String message) { //產生帶有參數的建構方法
		this.code = code;
		this.message = message;
	}

	public int getCode() {	//這邊只會用到get因此只需要產生Get
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
