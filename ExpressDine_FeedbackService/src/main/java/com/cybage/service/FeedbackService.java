package com.cybage.service;

import java.util.List;

import com.cybage.model.Feedback;

public interface FeedbackService {

	void addFeedback(Feedback feedback);

	List<Feedback> getAllFeedback();

}
