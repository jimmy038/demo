package com.example.demo.entity;

public class A1 extends C { //A1�~��C���O
	
//	private String city;
//	
//	private String State;
//	
//	private String county;
	
	//�ݩʭY���p�����إߧ��᳣�ݭn�إ�get��set��k
	private C c = new C(); //�������OC�w�]��,new ���OC 
	//�S���Y���~��HAS-A (�E�X)���S���ϥ�extends,���S���Y���~��
	
	private String address;	//�ݩʭY���p�����إߧ��᳣�ݭn�إ�get��set��k

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
