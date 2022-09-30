package com.cybage.service;

import java.util.List;

import com.cybage.model.Cart;
import com.cybage.model.Login;
import com.cybage.model.User;

public interface MailService {

	void sendOTP(String otp, String email);

	void sendRestOwnerDetails(User savedUser, Login login);

	void sendOrderDetails(List<Cart> cartItems);

	
}
