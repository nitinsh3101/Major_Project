package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.FavouriteRestaurantRepository;
import com.cybage.model.FavouriteRestaurant;

@Service
public class FavouriteRestaurantServiceImpl implements FavouriteRestaurantService{
	
	@Autowired
	private FavouriteRestaurantRepository favouriteRestaurantRepository;

	@Override
	public void addFavouriteRestaurant(FavouriteRestaurant favouriteRestaurant) {
		favouriteRestaurantRepository.save(favouriteRestaurant);
		
	}

	@Override
	public List<FavouriteRestaurant> findAllFavouriteRestaurant() {
		
		return favouriteRestaurantRepository.findAll();
	}

	@Override
	public void deleteFavouriteRestaurant(int id) {
		favouriteRestaurantRepository.deleteById(id);
		
	}

	@Override
	public List<FavouriteRestaurant> getFavouriteRestaurant(int userId) {
		
		return favouriteRestaurantRepository.getByUserId(userId);
	}


}
