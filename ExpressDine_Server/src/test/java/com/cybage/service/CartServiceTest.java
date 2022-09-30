package com.cybage.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cybage.dao.CartRepository;
import com.cybage.model.Cart;

@RunWith(SpringRunner.class)
@SpringBootTest
class CartServiceTest {
	
	@MockBean
	private CartRepository cartRepository;

	@Test
	void testAddToCart() {
		Cart cart=new Cart(1,5);
		Mockito.when(cartRepository.save(cart)).thenReturn(cart);
		assertThat(cart.getId()==1);
		assertThat(cart !=null);
	}

	@Test
	void testUpdateQuantity() {
		Cart cart=new Cart(1,5);
		assertThat(cart.getId() > 0);
		Mockito.when(cartRepository.getById((int)1)).thenReturn(cart);

		cart.setAmount(50);
		cart.setQuantity(2);

		Mockito.when(cartRepository.save(cart)).thenReturn(cart);
	}

	@Test
	void testDeleteItem() {
		Cart cart=new Cart(1,5);
		assertThat(cart.getId() > 0);
		Mockito.when(cartRepository.getById((int) 1)).thenReturn(cart);
	}

	
}
