package com.cybage.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cybage.dao.FoodRepository;
import com.cybage.model.Food;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodServiceTest {

	@Autowired
	private FoodService foodService;

	@MockBean
	private FoodRepository foodRepository;

	@Test
	public void testAddFood() {
		Food food = new Food(5, "veg", 105, 1, "shwarma");
		Mockito.when(foodRepository.save(food)).thenReturn(food);
		assertThat(food.getId() == 5);
		assertThat(food != null);
	}

	@Test
	public void testFindAllFood() {
		Food food1 = new Food(6, "Nonveg", 115, 4, "Chickenshwarma");
		Food food2 = new Food(7, "veg", 225, 3, "shwarma");

		List<Food> foodList = new ArrayList<>();

		foodList.add(food1);
		foodList.add(food2);

		Mockito.when(foodRepository.findAll()).thenReturn(foodList);
		assertThat(foodService.findAllFood(1)).isEqualTo(foodList);
	}

	@Test
	public void testUpdateFood() {
		Food food1 = new Food(6, "Nonveg", 115, 4, "Chickenshwarma");
		assertThat(food1.getId() > 0);
		Mockito.when(foodRepository.getById((int) 1)).thenReturn(food1);

		food1.setPrice(500);
		food1.setCategory("chinese");

		Mockito.when(foodRepository.save(food1)).thenReturn(food1);
	}

	@Test
	public void testDeleteFood() {
		Food food1 = new Food(6, "Nonveg", 115, 4, "Chickenshwarma");
		assertThat(food1.getId() > 0);
		Mockito.when(foodRepository.getById((int) 1)).thenReturn(food1);
	}

}
