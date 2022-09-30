package com.cybage.controller;

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
import org.springframework.web.client.RestTemplate;

import com.cybage.dto.UserDto;
import com.cybage.exception.UserNotFoundException;
import com.cybage.model.Login;
import com.cybage.model.User;
import com.cybage.service.MailService;
import com.cybage.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

	static Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private MailService mailService;

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
		User savedUser = userService.addUser(userDto.getUser());
		Login login = userDto.getLogin();
		login.setUserId(savedUser.getId());
		String url = "http://localhost:8081/addUserLogin";
		restTemplate.postForEntity(url, login, String.class);

		if (savedUser.getRole().equals("rest_owner")) {
			mailService.sendRestOwnerDetails(savedUser, login);
		}
		return new ResponseEntity<String>("Added successfully", HttpStatus.CREATED);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<String> editUser(@RequestBody User user, @PathVariable int id) {
		userService.addUser(user);
		logger.info("User Edited");
		return new ResponseEntity<>("User updated", HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getFoodById(@PathVariable int id) throws UserNotFoundException {
		User user = userService.findById(id);
		
		if(user==null)
		{
		   throw new UserNotFoundException("User not found");
		}
		
		logger.info("User find by Id");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
