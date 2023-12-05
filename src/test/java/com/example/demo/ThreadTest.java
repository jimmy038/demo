package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Bird;
import com.example.demo.entity.HorseRacing;

public class ThreadTest { //要跑執行續就是要呼叫start

	@Test //建立執行緒 – 繼承 Thread 類別
	public void multiThreadTest() {
		HorseRacing t1 = new HorseRacing("t1");
		HorseRacing t2 = new HorseRacing("t2");
		t1.start();
		t2.start();
	}
	
	@Test //建立執行緒 – 實作 Runnable 介面
	public void runnableTest() {
		Bird bird = new Bird();
		Thread t = new Thread(bird); //把Thread new出來再去呼叫類別內的start方法
		t.start();
		}
}

