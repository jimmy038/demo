package com.example.demo.vo;	//�bVO�o���JResponse(�^��),VO(Value object)�D�n�Ω��ƪ��]��

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;

// 						�����P�~�Ӫ�has a�ۦP,�@�����O���|�]�t�@�Ӧܦh�Ӫ����O
public class AtmResponse {	//Response�^�� ,request�ШD �q�`�|��o��ө�b�P�@�Ӹ�Ƨ�(Package)���U
	
	
	private Atm atm; //�p�G�b��@���䦨�\�F�n�^��atm�̭����F��,�ҥH�n��Atm�Զi��
	
	private RtnCode rtnCode; //�|�qAtmResponse���o�o��RtnCode,���o����A�hRtnCode�̭��hget code��message

	
	public AtmResponse() {
		super();
	}

	
	public RtnCode getRtnCode() {
		return rtnCode;
	}


	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
	
//  ��RtnCode�Զi�Ӥ���]code��message�bRtnCode�̭�,�ҥH�o�䪺�غc��k�u��atm��RtnCode
	public AtmResponse(Atm atm, RtnCode rtnCode) {
		super();
		this.atm = atm;
		this.rtnCode = rtnCode;
	}

	public Atm getAtm() {
		return atm;
	}

	public void setAtm(Atm atm) {
		this.atm = atm;
	}
	
	
}
