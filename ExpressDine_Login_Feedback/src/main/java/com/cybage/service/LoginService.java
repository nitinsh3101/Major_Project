package com.cybage.service;

import java.util.List;

import com.cybage.model.Login;

public interface LoginService {

	Login getById(Login user);

	void addAttempt(String email, String flag);

	void addLoginDetais(Login login);

	Login getByUserId(int userId);

	List<Login> getLockedAccounts();

	String unlockAccount(String email);

}