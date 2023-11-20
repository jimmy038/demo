package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;
import com.example.demo.repository.MealDao;
import com.example.demo.service.ifs.MealService;

@Service
public class MealServiceImpl implements MealService {
	
	@Autowired
	private MealDao mealDao;

	@Override
	public Meal findByName(String name) {
		return null;
	}

	@Override
	public Meal addMeal(Meal meal) {
		if(!StringUtils.hasText(meal.getName()) || !StringUtils.hasText(meal.getCooking_style()) 
				|| meal.getPrice() <=0) {
			return null;
		}
		if(mealDao.existsById(new MealId(meal.getName(),meal.getCooking_style()))) { //�]ID���D��Ѥ@��class���޲z,�����������Onew�X�ӦA�hget.������U@Id�����
			return null;
		}
		return mealDao.save(meal);
	}
}
