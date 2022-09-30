package com.cybage.service;

import java.util.List;

import com.cybage.model.Food;

public interface FoodService {

	void addFood(Food food);

	List<Food> findAllFood(int restId);
	
	void updateFood(int id, Food food);
	
	void deleteFood(int id);
	
	Food getFoodById(int id);

	List<Food> findByOwner(int userId);
	
//	void updateFood(int id);
}
