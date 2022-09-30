package com.cybage.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.FeedbackRepository;
import com.cybage.model.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public void addFeedback(Feedback feedback) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm");
		Date date = new Date(System.currentTimeMillis());
		String dateTime = formatter.format(date);

		feedback.setFeedbackOn(dateTime);
		feedbackRepository.save(feedback);

	}

	@Override
	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}

}
