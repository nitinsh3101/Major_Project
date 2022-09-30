package com.cybage.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cybage.dao.FavouriteFoodRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class FavouriteFoodServiceTest {

	@Autowired
	private FavouriteFoodService favouriteFoodService;

	@MockBean
	private FavouriteFoodRepository favouriteFoodRepository;

	@Test
	void testAddFavouriteFood() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteFavouriteFood() {
		fail("Not yet implemented");
	}

}
