package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

	List<Food> getFoodByRestaurantId(int id);

	List<Food> findByRestaurantId(int restId);



}
