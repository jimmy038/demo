package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Bird;
import com.example.demo.entity.HorseRacing;

public class ThreadTest { //�n�]������N�O�n�I�sstart

	@Test //�إ߰���� �V �~�� Thread ���O
	public void multiThreadTest() {
		HorseRacing t1 = new HorseRacing("t1");
		HorseRacing t2 = new HorseRacing("t2");
		t1.start();
		t2.start();
	}
	
	@Test //�إ߰���� �V ��@ Runnable ����
	public void runnableTest() {
		Bird bird = new Bird();
		Thread t = new Thread(bird); //��Thread new�X�ӦA�h�I�s���O����start��k
		t.start();
		}
}

