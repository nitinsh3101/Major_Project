package com.cybage.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.FavouriteFoodNotFoundException;
import com.cybage.model.FavouriteFood;
import com.cybage.service.FavouriteFoodService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/food")
public class FavouriteFoodController {
	
	static Logger logger=LogManager.getLogger(FavouriteFoodController.class);
	
	@Autowired
	private FavouriteFoodService favouriteFoodService;

	@PostMapping("/addFavouriteFood")
	public ResponseEntity<String> addFavouriteFood(@RequestBody FavouriteFood favouriteFood) {
		favouriteFoodService.addFavouriteFood(favouriteFood);
		logger.info("Favourite Food Added");
		return new ResponseEntity<String>("FavouriteFood added successfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteFavouriteFood/{id}")
	public ResponseEntity<String> deleteFavouriteFood(@PathVariable int id) {
		favouriteFoodService.deleteFavouriteFood(id);
		logger.info("Favourite Food Deleted");
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

	@GetMapping("/getFavouriteFood/{userId}")
	public ResponseEntity<List<FavouriteFood>> getFavouriteFood(@PathVariable int userId) throws FavouriteFoodNotFoundException {
		List<FavouriteFood> favouriteFood = favouriteFoodService.getFavouriteFoodByUserId(userId);
		if(favouriteFood==null)
		{
		   throw new FavouriteFoodNotFoundException("FavouriteFood not found");
		}
		logger.info("Favourite Food Found");
		return new ResponseEntity<>(favouriteFood, HttpStatus.OK);
	}

}
