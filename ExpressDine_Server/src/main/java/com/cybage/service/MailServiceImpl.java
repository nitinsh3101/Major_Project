package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.cybage.model.Cart;
import com.cybage.model.Login;
import com.cybage.model.User;

@Transactional
@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public void sendOTP(String otp, String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("Trng1@evolvingsols.com");
		message.setTo(email);
		message.setSubject("OTP for loging in to ExpressDine");
		message.setText("Use this otp for login  : " + otp + "\nPlease do not share your otp with anyone.");
		mailSender.send(message);

	}

	@Override
	public void sendRestOwnerDetails(User user, Login login) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("Trng1@evolvingsols.com");
		message.setTo(login.getEmail());
		message.setCc("shubhamman@cybage.com");
		message.setSubject("Your Login credentials for ExpressDine");
		message.setText("Hello " + user.getName() + "\nExpressDine welcomes you to the world of opportunities."
				+ "Your account at ExpressDine has been created successfully.\n"
				+ "Please find below your details for login\n" + "\nLogin Id : " + login.getEmail() + "\nPassword : "
				+ login.getPassword() + "\n\nYour account details : \n" + "Name : " + user.getName() + "\nPhone : "
				+ user.getPhone() + "\nAddress : " + user.getAddress()
				+ "\n\nNote : You are adviced to change your password at first login for security reasons."
				+ "\nThank you.");
		mailSender.send(message);

	}

	@Override
	public void sendOrderDetails(List<Cart> cartItems) {

		for (Cart item : cartItems) {

			int ownerId = item.getFood().getRestaurant().getOwner().getId();
	
			ResponseEntity<Login> login = restTemplate.getForEntity("http://localhost:8081/getByUserId/"+ownerId, Login.class);
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("Trng1@evolvingsols.com");
			message.setTo(login.getBody().getEmail());
			message.setCc("shubhamman@cybage.com");
			message.setSubject("Details of new order");
			message.setText("A new order has been placed for \n" + item.getQuantity() + " quantities of "
					+ item.getFood().getName() +" by "+item.getUser().getName()+ "\n\nPlease accept the order." + "\nRegards,\nExpressDine.");
			mailSender.send(message);
		}
	}


}
