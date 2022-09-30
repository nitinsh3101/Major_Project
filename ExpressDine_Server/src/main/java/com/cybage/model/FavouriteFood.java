package com.cybage.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class FavouriteFood {

	@Id
	@GeneratedValue
	private int id;

	@JsonBackReference
	@ManyToOne
	private User user;

	@OneToOne(cascade = CascadeType.MERGE)
	private Food food;

	public FavouriteFood() {
		super();
	}

	public FavouriteFood(User user, Food food) {
		super();
		this.user = user;
		this.food = food;
	}

	public FavouriteFood(int id, User user, Food food) {
		super();
		this.id = id;
		this.user = user;
		this.food = food;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setFood(Food food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "FavouriteFood [id=" + id + ", user=" + user + ", food=" + food + "]";
	}

}
