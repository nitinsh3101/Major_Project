package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Login;
import com.cybage.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/getById")
	public Login getById(@RequestBody Login user) {
		return loginService.getById(user);
	}

	@PostMapping("/countLoginAttempt/{email}")
	public String countAttempt(@RequestBody String flag, @PathVariable String email) {

		loginService.addAttempt(email, flag);
		return "Count added";
	}

	@PostMapping("/addUserLogin")
	public String addLoginDetails(@RequestBody Login login) {

		loginService.addLoginDetais(login);
		return "Details added";
	}
	
	@GetMapping("/getByUserId/{userId}")
	public Login getByUserId(@PathVariable int userId) {
		return loginService.getByUserId(userId);
	}
	
	@GetMapping("/getLockedAccounts")
	public List<Login> getLockedAccounts(){
		return loginService.getLockedAccounts();
	}
	
	
	@PostMapping("/unlockAccount")
	public String unlockAccount(@RequestBody String email) {
		return loginService.unlockAccount(email);
	}
}
