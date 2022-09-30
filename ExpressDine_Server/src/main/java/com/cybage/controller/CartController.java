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

import com.cybage.model.Cart;
import com.cybage.service.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cart")
public class CartController {
	
	static Logger logger=LogManager.getLogger(CartController.class);

	@Autowired
	private CartService cartService;
	
	@PostMapping("/addItem")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart) {
		System.out.println(cart);
		cartService.addToCart(cart);
		logger.info("Cart Added");
		return new ResponseEntity<String>("Cart Added successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/getItems/{userId}")
	public ResponseEntity<List<Cart>> getCartItems(@PathVariable int userId) {
		List<Cart> cartItems = cartService.getCartItems(userId); 
		logger.info("Cart items founded");
		return new ResponseEntity<>(cartItems, HttpStatus.OK);
	}
	
	@PutMapping("/changeQuantity")
	public ResponseEntity<String> changeQuantity(@RequestBody Cart cart){
		cartService.updateQuantity(cart);
		logger.info("Cart quantity Changed");
		return new ResponseEntity<>("Cart updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable int id){
		cartService.deleteItem(id);
		logger.info("Cart item removed");
		return new ResponseEntity<>("Cart itme removed", HttpStatus.OK);
	}
	
}
