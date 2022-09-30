package com.cybage.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.OrderRepository;
import com.cybage.dao.RestaurantRepository;
import com.cybage.model.Cart;
import com.cybage.model.Food;
import com.cybage.model.Order;
import com.cybage.model.Restaurant;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CartService cartService;

	@Autowired
	private MailService mailService;

	@Autowired
	private RestaurantRepository restaurantRepoository;

	@Override
	public void placeOrder(int userId) {
		List<Cart> cartItems = cartService.getCartItems(userId);

		mailService.sendOrderDetails(cartItems);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm");
		Date date = new Date(System.currentTimeMillis());
		String dateTime = formatter.format(date);

		for (Cart cart : cartItems) {
			Order order = new Order();
			System.out.println("in order");
			order.setIsAccepted("no");
			order.setAmount(cart.getFood().getPrice() * cart.getQuantity());
			order.setFood(cart.getFood());
			order.setOrderedOn(dateTime);
			order.setQuantity(cart.getQuantity());
			order.setStatus("pending");
			order.setTimeElapsed(0);
			order.setUser(cart.getUser());

			orderRepository.save(order);
			order = null;
		}

		cartService.removeCartItems(userId);

	}

	@Override
	public List<Order> getByUser(int id) {
		List<Order> list =  orderRepository.getByUserId(id);
		Collections.reverse(list);
		return list;

	}


	@Override
	public void acceptOrder(int orderId) {
		Order order = orderRepository.getById(orderId);
		order.setIsAccepted("yes");
		orderRepository.save(order);
	}


	@Override
	public List<Order> getOrders(int ownerId) {

		Restaurant restaurant = restaurantRepoository.getRestaurantByOwnerId(ownerId);
		List<Food> foodList = restaurant.getFoodList();
		List<Order> newList = new ArrayList<>();

		for (Food food : foodList) {
			List<Order> orderList = orderRepository.findByFoodId(food.getId());
			newList.addAll(orderList);
		}
		
		Collections.reverse(newList);
		return newList;
	}

}
