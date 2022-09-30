package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.FoodRepository;
import com.cybage.dao.RestaurantRepository;
import com.cybage.model.Food;
import com.cybage.model.Restaurant;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	public void addFood(Food food) {
		foodRepository.save(food);   //adding food by object
	}

	@Override
	public void updateFood(int id, Food food) {
		Food oldFood = foodRepository.getById(id);
		oldFood.setName(food.getName());
		oldFood.setPrice(food.getPrice());
		oldFood.setCategory(food.getCategory());
		
		foodRepository.save(oldFood);  //updating food by object

	}

	@Override
	public void deleteFood(int id) {
		foodRepository.deleteById(id);  //deleting food by id

	}

	@Override
	public Food getFoodById(int id) {

		return foodRepository.findById(id).orElse(null);  //fetching food by id
	}

	@Override
	public List<Food> findAllFood(int restId) {
		
		return foodRepository.findByRestaurantId(restId);  //fetching all food by restId 
	}

	@Override
	public List<Food> findByOwner(int userId) {
		Restaurant restaurant = restaurantRepository.findByOwnerId(userId);
		
		return foodRepository.findByRestaurantId(restaurant.getId()); //finding food by Owner using restId
	}

}
