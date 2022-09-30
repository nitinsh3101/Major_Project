package com.cybage.service;

import java.util.List;

import com.cybage.model.Order;

public interface OrderService {

	void placeOrder(int userId);

	List<Order> getByUser(int id);

	void acceptOrder(int orderId);


	List<Order> getOrders(int ownerId);

}
