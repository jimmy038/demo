package com.example.demo.constants; //constants�`�Ʊ`�q���N��

//enum�榡�������C�|�ҥH�����ݼgSUCCESSFUL(200,"OK!")���\�άO���~���T���X��
//���~�T�����|�g�b�o��	RtnCode��returnCode���N��
public enum RtnCode { //���إ�package�A�إ�enum(�C�|),���WRtnCode,�o�����~�T��,�N���~�T�����󦡦C�X
	
//	SUCCESSFUL�����\,()�����dHTTP���A�X,�D�n��200,400,401,403,404, 200�����\,�T�w��,�v����������401&403,404�T�w�N���䤣��,�ѤU�k����400
	SUCCESSFUL(200,"SUCCESSFUL!!"),//  			�b�r���᭱�[�W���ѲŸ����_�檺�ηN
	PARAM_ERROR(400,"Param_error!!"),//  Param_error�Ѽƿ��~���N�� �q�`�r�ꤺ�e���e���T�����p�g
	ACCOUNT_EXISTED(400,"Account existed!!"),//  Account existed�b��w�s�b
	ACCOUNT_NOT_FOUND(404,"Account not found!!"),//  Account not found�䤣�즹�b��
	INSUFFICIENT_BLANCE(400,"Insufficient Blance!!"), //  Insufficient_Blance�l�B����
	LOGIN_ERROR(400,"Login error!!"), //
	PLEASE_LOGIN_FIRST(400,"please Login First!!")
	;
	
	private int code; //�o�䪺code�����O�N�X,�^�Ǥ@�ӥN�X
	
	private String message;

	private RtnCode(int code, String message) { //���ͱa���Ѽƪ��غc��k
		this.code = code;
		this.message = message;
	}

	public int getCode() {	//�o��u�|�Ψ�get�]���u�ݭn����Get
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
