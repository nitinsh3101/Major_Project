package com.cybage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.OrderFeedback;
import com.cybage.service.OrderFeedbackService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/orderFeedback")
public class OrderFeedbackController {
	
	static Logger logger=LogManager.getLogger(OrderFeedbackController.class);
	
	@Autowired
	private OrderFeedbackService orderFeedbackService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addOrderFeedback(@RequestBody OrderFeedback orderFeedback) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm");
		Date date = new Date(System.currentTimeMillis());
		String dateTime = formatter.format(date);
		
		orderFeedback.setFeedbackOn(dateTime);
		orderFeedbackService.addOrderFeedback(orderFeedback);
		logger.info("OrderFeedback given");
		
		return new ResponseEntity<String>("OrderFeedback added successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<OrderFeedback>> addOrderFeedback() {
		logger.info("OrderFeedback displayed");
		return new ResponseEntity<List<OrderFeedback>>(orderFeedbackService.findOrderFeedback(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<OrderFeedback> getOrderFeedbackById(@PathVariable int id) {
		OrderFeedback orderFeedback = orderFeedbackService.getOrderFeedbackById(id);
		logger.info("OrderFeedback find by Id");
		return new ResponseEntity<>(orderFeedback, HttpStatus.OK);
	}
	
	@GetMapping("/getByRestaurant/{ownerId}")
	public ResponseEntity<List<OrderFeedback>> getByRestaurant(@PathVariable int ownerId){
		List<OrderFeedback> feedBackList = orderFeedbackService.getByRestaurant(ownerId);
		
		return new ResponseEntity<>(feedBackList, HttpStatus.OK);
	}
	
	
}
