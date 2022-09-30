package com.cybage.service;

import java.util.List;

import com.cybage.model.OrderFeedback;

public interface OrderFeedbackService {
	
	void addOrderFeedback(OrderFeedback orderFeedback);
	
	List<OrderFeedback> findOrderFeedback();
	
	OrderFeedback getOrderFeedbackById(int id);

	List<OrderFeedback> getByRestaurant(int ownerId);

}
