package com.cybage.service;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Service
public class SmsServiceImpl implements SmsService{

	
	private static final String ACCOUNT_SID = "AC2b36aa7ae807d4e5e700c56ce5b5c896";
	private static final String AUTH_TOKEN = "ef61b3c9665d277f6825b0e7f29c7526";
	private static final String TWILIO_NUMBER = "+14357103772";

	@Override
	public boolean sendSms(int otp) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
		    new PhoneNumber("+918605009090"),
		    new PhoneNumber(TWILIO_NUMBER),
		    "Sample Twilio SMS using Java"+otp)
		.create();
		System.out.println("Hello from sms");
		return true;
	}
	
	
}
