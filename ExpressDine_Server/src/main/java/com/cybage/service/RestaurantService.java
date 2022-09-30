package com.cybage.service;

import java.util.List;

import com.cybage.model.Restaurant;
import com.cybage.model.User;

public interface RestaurantService {
	void addRestaurant(Restaurant restaurant);

	List<Restaurant> findAllRestaurant();

	void updateRestaurant(int id, Restaurant restaurant);

	void deleteRestaurant(int id);

	Restaurant getRestaurantById(int id);

	void addRestaurantOwner(User user);

}
