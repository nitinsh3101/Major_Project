package com.cybage.service;

import java.util.List;

import com.cybage.model.Cart;

public interface CartService {

	void addToCart(Cart cart);

	List<Cart> getCartItems(int userId);

	void updateQuantity(Cart cart);

	void deleteItem(int id);

	void removeCartItems(int userId);

}
