package com.cybage.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Order;
import com.cybage.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/order")
public class OrderController {

	static Logger logger = LogManager.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	@PutMapping("/placeOrder/{userId}")
	public ResponseEntity<String> placeOrder(@PathVariable int userId) {
		orderService.placeOrder(userId);
		logger.info("Order Placed");
		return new ResponseEntity<>("Order placed", HttpStatus.OK);
	}

	@GetMapping("/getByUser/{id}")
	public ResponseEntity<List<Order>> getByUser(@PathVariable int id) {
		List<Order> orderList = orderService.getByUser(id);
		logger.info("Order Found");
		return new ResponseEntity<>(orderList, HttpStatus.OK);
	}

	@GetMapping("/getOrders/{ownerId}")
	public ResponseEntity<List<Order>> getOrders(@PathVariable int ownerId) {
		logger.info("Order Unaccepted");
		return new ResponseEntity<List<Order>>(orderService.getOrders(ownerId), HttpStatus.OK);
	}

	@PutMapping("/acceptOrder/{orderId}")
	public ResponseEntity<String> acceptOrder(@PathVariable int orderId) {
		orderService.acceptOrder(orderId);
		logger.info("Order will Accept");
		return new ResponseEntity<>("Order Accepted", HttpStatus.OK);
	}

}
