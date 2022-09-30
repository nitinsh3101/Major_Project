package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.dao.CartRepository;
import com.cybage.model.Cart;
import com.cybage.model.User;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public void addToCart(Cart cart) {
		int foodId = cart.getFood().getId();
		int userId = cart.getUser().getId();
		Cart oldCart = cartRepository.findByUserIdAndFoodId(userId, foodId);
		if (oldCart == null) {
			cart.setAmount(cart.getFood().getPrice());
			cartRepository.save(cart);
		}
	}

	@Override
	public List<Cart> getCartItems(int userId) {
		return cartRepository.findByUserId(userId);
	}

	@Override
	public void updateQuantity(Cart cart) {
		cartRepository.save(cart);

	}

	@Override
	public void deleteItem(int id) {
		cartRepository.deleteById(id);

	}

	@Override
	public void removeCartItems(int userId) {
		cartRepository.deleteByUserId(userId);

	}

}
