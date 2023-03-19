package net.javaguides.springboot.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Meal;
import net.javaguides.springboot.repository.MealRepository;

@Service
public class MealService {

	@Autowired
	MealRepository mealRepository;

	public void save(Meal meal, String userName) {
		meal.setCreatedBy(userName);
		meal.setCreatedAt(new Date());
		mealRepository.save(meal);
	}

	public Meal findByCreatedBy(String createdBy) {
		return mealRepository.findTopByCreatedByOrderByCreatedAtDesc(createdBy);
	}

}
