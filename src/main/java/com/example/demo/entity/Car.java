package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

			//Car���O,��@(implements)����(RunService)
public class Car implements RunService{

	@Override
	public void run() {	//����L�CCar���O,�ICar���O��add�Უ�ͪ����s�w�q��k
		System.out.println("BMW�u�w��,Aitls�������");
	}

}
