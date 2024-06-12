package com.example.demo.entity;

//�إ߰���� �V �~�� Thread ���O
public class HorseRacing extends Thread{

	//�غc��k
	public HorseRacing(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 5 ; i++) {
			System.out.println(getName() + "�ثe���b�]��" + i + "��");
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
