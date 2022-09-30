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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.ComplaintNotFoundException;
import com.cybage.model.Complaint;
import com.cybage.service.ComplaintService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/complaint")
public class ComplaintController {

	static Logger logger = LogManager.getLogger(FoodController.class);

	@Autowired
	private ComplaintService complaintService;

	@PostMapping("/add")
	public ResponseEntity<String> addComplaint(@RequestBody Complaint complaint) {
		complaintService.addComplaint(complaint);
		logger.info("Complaint Added");
		return new ResponseEntity<String>("Complaint added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/getByRestOwner/{id}")
	public ResponseEntity<List<Complaint>> getComplaintByRestOwnerId(@PathVariable int id)
			throws ComplaintNotFoundException {
		List<Complaint> complaint = complaintService.getComplaintByRestOwnerId(id);

		if (complaint == null) {
			throw new ComplaintNotFoundException("Complaint not found");
		}

		logger.info("Complaint Received By Rest Owner");
		return new ResponseEntity<>(complaint, HttpStatus.OK);
	}
	
	@PutMapping("/resolve/{id}")
	public ResponseEntity<String> resolveComplaint(@PathVariable int id) {
		complaintService.resolveComplaint(id);
		logger.info("Complaint Resolved");
		return new ResponseEntity<String>("Complaint resolved successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/getByUser/{id}")
	public ResponseEntity<List<Complaint>> getComplaintsByUser(@PathVariable int id)
			throws ComplaintNotFoundException {
		List<Complaint> complaint = complaintService.getComplaintsByUser(id);

		if (complaint == null) {
			throw new ComplaintNotFoundException("Complaint not found");
		}

		logger.info("Complaint Received By Rest Owner");
		return new ResponseEntity<>(complaint, HttpStatus.OK);
	}

}
