package com.cybage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.dto.UserDto;
import com.cybage.model.Login;
import com.cybage.model.User;
import com.cybage.service.MailService;
import com.cybage.service.SmsService;
import com.cybage.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginClientController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	UserService userService;

	@Autowired
	private MailService mailService;

	@Autowired
	private SmsService smsService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login) {
		ResponseEntity<Login> response = restTemplate.postForEntity("http://localhost:8081/getById", login,
				Login.class);

		List<Object> list = new ArrayList<>();
		Login newlogin = response.getBody();
		if (response.hasBody()) {
			User newUser = userService.findById(newlogin.getUserId());

			Random random = new Random();
			String otp = String.format("%04d", random.nextInt(10000));
			list.add(newUser);
			list.add(newlogin);
			list.add(otp);
			System.out.println(otp);
			// smsService.sendSms(otp);
			if (newlogin.getAttempts() < 3) {
				mailService.sendOTP(otp, newlogin.getEmail());
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
		}

	}

	@PostMapping("/countLoginAttempt/{email}")
	public ResponseEntity<String> countAttempt(@PathVariable String email, @RequestBody String flag) {
		String url = "http://localhost:8081/countLoginAttempt/" + email;
		restTemplate.postForEntity(url, flag, String.class);
		return new ResponseEntity<>("Attempt added", HttpStatus.OK);
	}

	@PostMapping("/addUserLogin")
	public ResponseEntity<String> countAttempt(@RequestBody Login login) {
		String url = "http://localhost:8081/addUserLogin";
		restTemplate.postForEntity(url, login, String.class);
		return new ResponseEntity<>("Details added", HttpStatus.OK);
	}

	@GetMapping("/getLockedAccounts")
	public ResponseEntity<List<UserDto>> getLockedAccounts() {
		ResponseEntity<Login[]> loginList = restTemplate.getForEntity("http://localhost:8081/getLockedAccounts",
				Login[].class);

		List<UserDto> newList = new ArrayList<UserDto>();

		for (Login login : loginList.getBody()) {
			UserDto userDto = new UserDto();
			User user = userService.findById(login.getUserId());
			userDto.setLogin(login);
			userDto.setUser(user);
			newList.add(userDto);
		}

		return new ResponseEntity<>(newList, HttpStatus.OK);
	}

	@PutMapping("/unlock/{email}")
	public ResponseEntity<String> unlockAccount(@PathVariable String email) {
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/unlockAccount", email,
				String.class);

		return new ResponseEntity<String>(response.getBody(), HttpStatus.OK);
	}

}
