package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.FavouriteRestaurant;

@Repository
public interface FavouriteRestaurantRepository extends JpaRepository<FavouriteRestaurant, Integer>{

	List<FavouriteRestaurant> getByUserId(int userId);


}
