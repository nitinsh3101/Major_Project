package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.OrderFeedback;

@Repository
public interface OrderFeedbackRepository extends JpaRepository<OrderFeedback, Integer> {

	OrderFeedback findByOrderId(int id);

}
