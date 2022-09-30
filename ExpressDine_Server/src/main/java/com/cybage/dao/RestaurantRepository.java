package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Restaurant;
import com.cybage.model.User;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	void save(User user);

	List<Restaurant> getRestaurantByName(String name);

	Restaurant getRestaurantByOwnerId(int ownerId);

	Restaurant findByOwnerId(int userId);

}
