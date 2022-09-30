package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.LoginRepository;
import com.cybage.model.Login;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Login getById(Login user) {
		return loginRepository.findById(user.getEmail()).orElse(null);

	}

	@Override
	public void addLoginDetais(Login login) {
		loginRepository.save(login);
	}

	@Override
	public void addAttempt(String email, String flag) {
		Login login = loginRepository.findById(email).orElse(null);
		if (flag.equals("false=")) {
			login.setAttempts(0);
		} else {
			login.setAttempts(login.getAttempts() + 1);
		}
		loginRepository.save(login);
	}

	@Override
	public Login getByUserId(int userId) {

		return loginRepository.getByUserId(userId);
	}

	@Override
	public List<Login> getLockedAccounts() {
		List<Login> list = loginRepository.findAll();
		List<Login> newList = new ArrayList<>();

		for (Login login : list) {
			if (login.getAttempts() > 2) {
				newList.add(login);
			}
		}
		return newList;
	}

	@Override
	public String unlockAccount(String email) {
		Login login = loginRepository.getById(email);
		login.setAttempts(0);
		loginRepository.save(login);
		return "Attempts set to zero";
	}

}
