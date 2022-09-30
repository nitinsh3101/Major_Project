package com.cybage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;
	private String role;
	private String phone;

	@JsonManagedReference
	@OneToOne(mappedBy = "owner", cascade = CascadeType.MERGE)
	private Restaurant restaurant;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	private List<Cart> cartItemsList;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	private List<Order> order;

	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	private List<FavouriteRestaurant> favouriteRestaurant;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	private List<FavouriteFood> favouriteFood;

	public User() {
		super();
	}

	public User(int id, String name, String address, String role, String phone, Restaurant restaurant) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.role = role;
		this.phone = phone;
		this.restaurant = restaurant;
	}

	
	
	public User(int id, String name, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public User(int id, String name, String address, String role, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.role = role;
		this.phone = phone;
	}

	public User(String name, String address, String role, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.role = role;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Cart> getCartItemsList() {
		return cartItemsList;
	}

	public void setCartItemsList(List<Cart> cartItemsList) {
		this.cartItemsList = cartItemsList;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public List<FavouriteRestaurant> getFavouriteRestaurant() {
		return favouriteRestaurant;
	}

	public void setFavouriteRestaurant(List<FavouriteRestaurant> favouriteRestaurant) {
		this.favouriteRestaurant = favouriteRestaurant;
	}

	public List<FavouriteFood> getFavouriteFood() {
		return favouriteFood;
	}

	public void setFavouriteFood(List<FavouriteFood> favouriteFood) {
		this.favouriteFood = favouriteFood;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", role=" + role + ", phone=" + phone
				+ "]";
	}

}