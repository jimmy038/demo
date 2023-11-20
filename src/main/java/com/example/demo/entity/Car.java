package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

			//Car類別,實作(implements)介面(RunService)
public class Car implements RunService{

	@Override
	public void run() {	//對紅蚯蚓Car類別,點Car類別的add後產生的重新定義方法
		System.out.println("BMW真滴帥,Aitls國民神車");
	}

}
