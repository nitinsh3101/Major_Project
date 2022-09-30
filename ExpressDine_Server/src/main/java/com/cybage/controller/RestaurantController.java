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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.RestaurantNotFoundException;
import com.cybage.model.Restaurant;
import com.cybage.service.RestaurantService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/restaurant")
public class RestaurantController {
	
	static Logger logger=LogManager.getLogger(RestaurantController.class);

	@Autowired
	private RestaurantService restaurantService;

	@PostMapping("/add")
	public ResponseEntity<String> addRestaurant(@RequestBody Restaurant restaurant) {
		restaurantService.addRestaurant(restaurant);
		logger.info("Restaurant Added");
		return new ResponseEntity<String>("Restaurant Added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Restaurant>> getAllRestaurant() {
		logger.info("Restaurant Displayed");
		return new ResponseEntity<List<Restaurant>>(restaurantService.findAllRestaurant(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable int id) {
		restaurantService.deleteRestaurant(id);
		logger.info("Restaurant Deleted");
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<String> editRestaurant(@RequestBody Restaurant restaurant, @PathVariable int id) {
		restaurantService.updateRestaurant(id, restaurant);
		logger.info("Restaurant Edited");
		return new ResponseEntity<>("Restaurant updated", HttpStatus.CREATED);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id) throws RestaurantNotFoundException {
		Restaurant restaurant = restaurantService.getRestaurantById(id);
		
		if(restaurant==null)
		{
		   throw new RestaurantNotFoundException("Restaurant not found");
		}
		logger.info("Restaurant find by Id");
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}


}
