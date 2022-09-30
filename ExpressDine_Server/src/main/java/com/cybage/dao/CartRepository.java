package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Cart;
import com.cybage.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> getByUserId(int userId);

	List<Cart> findByUserId(int userId);

	Cart findByUserIdAndFoodId(int userId, int foodId);

	void deleteByUserId(int userId);

	void deleteByUser(User user);

}
