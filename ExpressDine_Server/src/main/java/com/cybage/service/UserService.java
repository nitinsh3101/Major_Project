package com.cybage.service;

import com.cybage.model.User;

public interface UserService {

	User findById(int id);

	User addUser(User user);

	


}
