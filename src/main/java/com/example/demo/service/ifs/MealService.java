package com.example.demo.service.ifs;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Meal;

@Service
public interface MealService {
	
	public Meal addMeal(Meal meal);//�s�W��k
	
	public Meal findByName(String name); //�s�W
}
