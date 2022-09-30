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

import com.cybage.model.FavouriteRestaurant;
import com.cybage.service.FavouriteRestaurantService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/restaurant")
public class FavouriteRestaurantController {
	
	static Logger logger=LogManager.getLogger(FavouriteRestaurantController.class);
	
	@Autowired
	private FavouriteRestaurantService favouriteRestaurantService;
	
	@PostMapping("/addFavouriteRestaurant")
	public ResponseEntity<String> addFavouriteRestaurant(@RequestBody FavouriteRestaurant favouriteRestaurant) {
		favouriteRestaurantService.addFavouriteRestaurant(favouriteRestaurant);
		logger.info("Favourite Restaurant Added");
		return new ResponseEntity<String>("FavouriteRestaurant added successfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteFavouriteRestaurant/{id}")
	public ResponseEntity<String> deleteFavouriteRestaurant(@PathVariable int id) {
		favouriteRestaurantService.deleteFavouriteRestaurant(id);
		logger.info("Favourite Restaurant Deleted");
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

	@GetMapping("/getFavouriteRestaurant/{userId}")
	public ResponseEntity<List<FavouriteRestaurant>> getFavouriteRestaurant(@PathVariable int userId) {
		List<FavouriteRestaurant> favouriteRestaurant = favouriteRestaurantService.getFavouriteRestaurant(userId);
		return new ResponseEntity<>(favouriteRestaurant, HttpStatus.OK);
	}

	
}
