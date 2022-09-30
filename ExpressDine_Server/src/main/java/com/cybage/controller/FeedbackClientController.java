package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.model.Feedback;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/feedback")
public class FeedbackClientController {

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/add")
	public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback) {

		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8082/addFeedback", feedback,
				String.class);
		return response;
	}

	@GetMapping("/getAll")
	public ResponseEntity<Feedback[]> getAllFeedback() {
		ResponseEntity<Feedback[]> response = restTemplate.getForEntity("http://localhost:8082/getAllFeedback", Feedback[].class);
		
		return response;
		
	}

}
