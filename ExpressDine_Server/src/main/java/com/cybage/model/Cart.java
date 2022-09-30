package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private int id;
	private int quantity;
	private float amount;

	@OneToOne
	private User user;

	@OneToOne
	private Food food;

	public Cart() {
		super();
	}

	public Cart(int quantity, float amount, User user, Food food) {
		super();
		this.quantity = quantity;
		this.amount = amount;
		this.user = user;
		this.food = food;
	}

	public Cart(int id, int quantity, float amount, User user, Food food) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.amount = amount;
		this.user = user;
		this.food = food;
	}

	public Cart(int id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Food getFood() {
		return food;
	}

	public void setFoodList(Food food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + ", amount=" + amount + ", user=" + user + ", food=" + food
				+ "]";
	}

}
