package com.example.demo.service.ifs;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Meal;

@Service
public interface MealService {
	
	public Meal addMeal(Meal meal);//新增方法
	
	public Meal findByName(String name); //新增
}
