package com.example.demo.entity;

//建立執行緒 – 繼承 Thread 類別
public class HorseRacing extends Thread{

	//建構方法
	public HorseRacing(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 5 ; i++) {
			System.out.println(getName() + "目前正在跑第" + i + "圈");
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
