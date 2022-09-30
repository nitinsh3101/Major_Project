package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login{

	@Id
	private String email;
	private String password;
	private int attempts;
	private int userId;


	public Login(String email, String password, int attempts,int userId) {
		super();
		this.email = email;
		this.password = password;
		this.attempts = attempts;
		this.userId = userId;
	}



	public Login() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + ", attempts=" + attempts
				+ ", userId=" + userId + "]";
	}

}
