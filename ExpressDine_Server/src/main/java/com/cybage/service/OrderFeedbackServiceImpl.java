package com.cybage.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.OrderFeedbackRepository;
import com.cybage.dao.OrderRepository;
import com.cybage.dao.RestaurantRepository;
import com.cybage.model.Complaint;
import com.cybage.model.Food;
import com.cybage.model.Order;
import com.cybage.model.OrderFeedback;
import com.cybage.model.Restaurant;

@Service
public class OrderFeedbackServiceImpl implements OrderFeedbackService{
	
	
	@Autowired
	private OrderFeedbackRepository orderFeedbackRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepoository;
	

	@Autowired
	OrderRepository orderRepository;
	
	
	@Override
	public void addOrderFeedback(OrderFeedback orderFeedback) {
		orderFeedbackRepository.save(orderFeedback);
		
	}

	@Override
	public List<OrderFeedback> findOrderFeedback() {
	
		return orderFeedbackRepository.findAll();
	}

	@Override
	public OrderFeedback getOrderFeedbackById(int id) {
		
		return orderFeedbackRepository.findById(id).orElse(null);
	}

	@Override
	public List<OrderFeedback> getByRestaurant(int ownerId) {
		Restaurant restaurant = restaurantRepoository.getRestaurantByOwnerId(ownerId);
		List<Food> foodList = restaurant.getFoodList();
		List<OrderFeedback> OrderFeedbackList = new ArrayList<>();

//		iterating foodList and getting each food
		for (Food food : foodList) {
			List<Order> orderList = orderRepository.findByFoodId(food.getId());

//			iterating orderList and getting each order
			for (Order order : orderList) {
				OrderFeedback orderFeedback = orderFeedbackRepository.findByOrderId(order.getId());
				if(orderFeedback != null)
					OrderFeedbackList.add(orderFeedback);
			}
		}
		return OrderFeedbackList;
	}

}
