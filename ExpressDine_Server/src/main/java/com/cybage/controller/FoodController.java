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

import com.cybage.exception.FoodNotFoundException;
import com.cybage.model.Food;
import com.cybage.service.FoodService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/food")
public class FoodController {
	
	static Logger logger=LogManager.getLogger(FoodController.class);

	@Autowired
	private FoodService foodService;

	@PostMapping("/add")
	public ResponseEntity<String> addFood(@RequestBody Food food) {
		foodService.addFood(food);
		logger.info("Food Ordered");
		
		return new ResponseEntity<String>("Food added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/getAll/{restId}")
	public ResponseEntity<List<Food>> getAll(@PathVariable int restId) {
		logger.info("Food displayed");
		return new ResponseEntity<List<Food>>(foodService.findAllFood(restId), HttpStatus.OK);
	}
	
	@GetMapping("/getAllByOwner/{userId}")
	public ResponseEntity<List<Food>> getAllByOwner(@PathVariable int userId) {
		logger.info("Food displayed");
		return new ResponseEntity<List<Food>>(foodService.findByOwner(userId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFood(@PathVariable int id) {
		System.out.println(id);
		foodService.deleteFood(id);
		logger.info("Food Deleted");
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<String> editFood(@RequestBody Food food, @PathVariable int id) {
		foodService.updateFood(id, food);
		logger.info("Food Edited");
		return new ResponseEntity<>("Food updated", HttpStatus.CREATED);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable int id) throws FoodNotFoundException {
		Food food = foodService.getFoodById(id);
		if(food==null)
		{
		   throw new FoodNotFoundException("Food not found");
		}
				
		logger.info("Food find by Id");
		return new ResponseEntity<>(food, HttpStatus.OK);
	}

}