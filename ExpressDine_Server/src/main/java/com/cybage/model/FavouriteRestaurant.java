package com.cybage.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class FavouriteRestaurant {

	@Id
	@GeneratedValue
	private int id;

	@JsonBackReference
	@ManyToOne
	private User user;

	@OneToOne(cascade = CascadeType.MERGE)
	private Restaurant restaurant;

	public FavouriteRestaurant() {
		super();
	}

	public FavouriteRestaurant(User user, Restaurant restaurant) {
		super();
		this.user = user;
		this.restaurant = restaurant;
	}

	public FavouriteRestaurant(int id, User user, Restaurant restaurant) {
		super();
		this.id = id;
		this.user = user;
		this.restaurant = restaurant;
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "FavouriteRestaurant [id=" + id + ", user=" + user + ", restaurant=" + restaurant + "]";
	}

}
