package com.cybage.dto;

import com.cybage.model.Login;
import com.cybage.model.User;

public class UserDto {
	private User user;
	private Login login;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
