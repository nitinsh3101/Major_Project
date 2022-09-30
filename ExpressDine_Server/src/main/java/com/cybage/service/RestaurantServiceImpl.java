package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.RestaurantRepository;
import com.cybage.model.Restaurant;
import com.cybage.model.User;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	public void addRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}

	public List<Restaurant> findAllRestaurant() {
		return restaurantRepository.findAll();   //Fetching  All rest
	}

	@Override
	public void updateRestaurant(int id, Restaurant restaurant) {
		restaurantRepository.save(restaurant);    //updating rest by  object
	}

	@Override
	public void deleteRestaurant(int id) {
		System.out.println(id);
		restaurantRepository.deleteById(id);   //deleting rest by id 

	}

	@Override
	public Restaurant getRestaurantById(int id) {

		return restaurantRepository.findById(id).orElse(null); //fetching rest by id 
	}

	@Override
	public void addRestaurantOwner(User user) {
		restaurantRepository.save(user);  //adding restOwner by Userid 

	}

}
