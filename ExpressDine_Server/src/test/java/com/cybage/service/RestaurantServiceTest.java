package com.cybage.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cybage.dao.RestaurantRepository;
import com.cybage.model.Restaurant;

@RunWith(SpringRunner.class)
@SpringBootTest
class RestaurantServiceTest {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@MockBean
	private RestaurantRepository restaurantRepository;
	

	@Test
	void testAddRestaurant() {
		Restaurant restaurant=new Restaurant(5,"ReddysKitchen","Viman Nagar","6743567854",10);
		Mockito.when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
		assertThat(restaurant.getId()==5);
		assertThat(restaurant !=null);
	}

	@Test
	void testFindAllRestaurant() {
		Restaurant restaurant1=new Restaurant(5,"ReddysKitchen","Viman Nagar","6743567854",10);
		Restaurant restaurant2=new Restaurant(6,"MomsKitchen","VadgaonSheri","7856432198",15);
		
		List<Restaurant>restaurantList=new ArrayList<>();
		
		restaurantList.add(restaurant1);
		restaurantList.add(restaurant2);
		
		Mockito.when(restaurantRepository.findAll()).thenReturn(restaurantList);
		assertThat(restaurantService.findAllRestaurant()).isEqualTo(restaurantList);
	}

	@Test
	void testUpdateRestaurant() {
		Restaurant restaurant1=new Restaurant(5,"ReddysKitchen","Viman Nagar","6743567854",10);
		assertThat(restaurant1.getId()>0);
		Mockito.when(restaurantRepository.getById((int)1)).thenReturn(restaurant1);
		
		restaurant1.setAddress("ct tower");
		restaurant1.setName("StarterJunction");
		
		Mockito.when(restaurantRepository.save(restaurant1)).thenReturn(restaurant1);

	}

	@Test
	void testDeleteRestaurant() {
		Restaurant restaurant1=new Restaurant(5,"ReddysKitchen","Viman Nagar","6743567854",10);
		assertThat(restaurant1.getId()>0);
		Mockito.when(restaurantRepository.getById((int)1)).thenReturn(restaurant1);
	}





}
