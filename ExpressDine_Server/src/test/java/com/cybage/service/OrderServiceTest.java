package com.cybage.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cybage.dao.OrderRepository;
import com.cybage.model.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {

	@MockBean
	private OrderRepository orderRepository;

	@Test
	void testPlaceOrder() {
		Order order = new Order(5, "pending", "may", 110, 2, "false", 10);
		Mockito.when(orderRepository.save(order)).thenReturn(order);
		assertThat(order.getId() == 5);
		assertThat(order != null);
	}

}
