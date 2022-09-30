package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.FavouriteFoodRepository;
import com.cybage.model.FavouriteFood;

@Service
public class FavouriteFoodServiceImpl implements FavouriteFoodService {

	@Autowired
	private FavouriteFoodRepository favouriteFoodRepository;

	@Override
	public void addFavouriteFood(FavouriteFood favouriteFood) {

		favouriteFoodRepository.save(favouriteFood);  

	}

	@Override
	public List<FavouriteFood> findAllFavouriteFood() {

		return favouriteFoodRepository.findAll();
	}

	@Override
	public void deleteFavouriteFood(int id) {

		favouriteFoodRepository.deleteById(id);
	}

	@Override
	public List<FavouriteFood> getFavouriteFoodByUserId(int userId) {

		return favouriteFoodRepository.getFavouriteFoodByUserId(userId);
	}

}
