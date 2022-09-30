package com.cybage.service;

import java.util.List;

import com.cybage.model.FavouriteRestaurant;

public interface FavouriteRestaurantService {
	
	void addFavouriteRestaurant(FavouriteRestaurant favouriteRestaurant);

	List<FavouriteRestaurant> findAllFavouriteRestaurant();

	void deleteFavouriteRestaurant(int id);


	List<FavouriteRestaurant> getFavouriteRestaurant(int userId);

}
