package com.cybage.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cybage.dao.UserRepository;
import com.cybage.model.Food;
import com.cybage.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired 
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;

	
	@Test
	public void testAddUser() {
		User user=new User(5,"tulsi nagar","shubham","7654328965");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertThat(user.getId()==5);
		assertThat(user !=null);
	}
	
//	@Test
//	public void testFindById() {
//		fail("Not yet implemented");
//	}
	
}
