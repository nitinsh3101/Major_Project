package com.cybage.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.ComplaintRepository;
import com.cybage.dao.FoodRepository;
import com.cybage.dao.OrderRepository;
import com.cybage.dao.RestaurantRepository;
import com.cybage.dao.UserRepository;
import com.cybage.model.Complaint;
import com.cybage.model.Food;
import com.cybage.model.Order;
import com.cybage.model.Restaurant;
import com.cybage.model.User;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;

	@Autowired
	private RestaurantRepository restaurantRepoository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	OrderRepository orderRepository;

	@Override
	public void addComplaint(Complaint complaint) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm");
		Date date = new Date(System.currentTimeMillis());
		String dateTime = formatter.format(date);
		complaint.setCommentedOn(dateTime);
		complaintRepository.save(complaint);
	}

	@Override
	public List<Complaint> getComplaintByRestOwnerId(int ownerId) {

		Restaurant restaurant = restaurantRepoository.getRestaurantByOwnerId(ownerId);
		List<Food> foodList = restaurant.getFoodList();
		List<Complaint> complaintList = new ArrayList<>();

//		iterating foodList and getting each food
		for (Food food : foodList) {
			List<Order> orderList = orderRepository.findByFoodId(food.getId());

//			iterating orderList and getting each order
			for (Order order : orderList) {
				Complaint complaint = complaintRepository.findByOrderId(order.getId());
				if(complaint != null)
					complaintList.add(complaint);
			}
		}
		return complaintList;
	}

	@Override
	public void resolveComplaint(int id) {
		Complaint complaint = complaintRepository.getById(id);
		complaint.setStatus("resolved");
		complaintRepository.save(complaint);
	}

	@Override
	public List<Complaint> getComplaintsByUser(int id) {
		User user = userRepository.getById(id);
		List<Order> orderList = user.getOrder();
		List<Complaint> complaintList = new ArrayList<>();
		
//		iterating orderList and getting each order
		for (Order order : orderList) {
			Complaint complaint = complaintRepository.findByOrderId(order.getId());
			if(complaint != null)
				complaintList.add(complaint);
		}
		return complaintList;
	}

}
