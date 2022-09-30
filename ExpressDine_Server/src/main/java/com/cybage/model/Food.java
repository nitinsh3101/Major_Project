package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Food {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private float price;
	private float deliveryTime;
	private String category;

	@JsonBackReference
	@ManyToOne
	private Restaurant restaurant;

	public Food() {
		super();
	}

	public Food(int id, String name, float price, float deliveryTime, String category, Restaurant restaurant) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.deliveryTime = deliveryTime;
		this.category = category;
		this.restaurant = restaurant;
	}
	
	

	public Food(int id, String name, float price, float deliveryTime, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.deliveryTime = deliveryTime;
		this.category = category;
	}

	public Food(String name, float price, float deliveryTime, String category, Restaurant restaurant) {
		super();
		this.name = name;
		this.price = price;
		this.deliveryTime = deliveryTime;
		this.category = category;
		this.restaurant = restaurant;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(float deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", price=" + price + ", deliveryTime=" + deliveryTime
				+ ", category=" + category + ", restaurant=" + restaurant + "]";
	}

}
