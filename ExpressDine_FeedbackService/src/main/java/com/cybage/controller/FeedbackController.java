package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Feedback;
import com.cybage.service.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	
	@PostMapping("/addFeedback")
	public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback){
		feedbackService.addFeedback(feedback);
		return new ResponseEntity<String>("Feedback Added", HttpStatus.OK);
	}
	
	@GetMapping("/getAllFeedback")
	public ResponseEntity<List<Feedback>> getAllFeedback(){
		List<Feedback> list = feedbackService.getAllFeedback();
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	
}
