package com.cybage.service;

import java.util.List;

import com.cybage.model.FavouriteFood;

public interface FavouriteFoodService {

	void addFavouriteFood(FavouriteFood favouriteFood);

	List<FavouriteFood> findAllFavouriteFood();

	void deleteFavouriteFood(int id);

	List<FavouriteFood> getFavouriteFoodByUserId(int userId);

}
