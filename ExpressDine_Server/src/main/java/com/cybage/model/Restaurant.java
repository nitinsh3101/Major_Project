package com.cybage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;
	private String phone;
	private float offerPercent;

	@JsonBackReference
	@OneToOne
	private User owner;

	@JsonManagedReference
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.MERGE)
	private List<Food> foodList;

	public Restaurant() {
		super();
	}

	public Restaurant(int id, String name, String address, String phone, float offerPercent, User owner) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.offerPercent = offerPercent;
		this.owner = owner;
	}

	public Restaurant(int id, String name, String address, String phone, float offerPercent) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.offerPercent = offerPercent;
	}

	public Restaurant(String name, String address, String phone, float offerPercent, User owner) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.offerPercent = offerPercent;
		this.owner = owner;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getOfferPercent() {
		return offerPercent;
	}

	public void setOfferPercent(float offerPercent) {
		this.offerPercent = offerPercent;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", offerPercent=" + offerPercent + ", owner=" + owner + ", foodList=" + foodList + "]";
	}

}
