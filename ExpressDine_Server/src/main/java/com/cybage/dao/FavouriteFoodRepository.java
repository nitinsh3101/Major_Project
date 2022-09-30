package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.FavouriteFood;

@Repository
public interface FavouriteFoodRepository extends JpaRepository<FavouriteFood, Integer> {

	List<FavouriteFood> getFavouriteFoodByUserId(int userId);

}
