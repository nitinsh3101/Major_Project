package com.cybage.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "order_table")
public class Order {

	@Id
	@GeneratedValue
	private int id;
	private String status;
	private String orderedOn;
	private float amount;
	private int quantity;
	private String isAccepted;
	private int timeElapsed;

	@ManyToOne
	private User user;

	@ManyToOne
	private Food food;

	@JsonIgnore
	@OneToOne(mappedBy = "order", cascade = CascadeType.MERGE)
	private Complaint complaint;

	@JsonIgnore
	@OneToOne(mappedBy = "order", cascade = CascadeType.MERGE)
	private OrderFeedback orderFeedback;

	public Order() {
		super();
	}

	public Order(String status, String orderedOn, float amount, int quantity, String isAccepted, User user, Food food,
			Complaint complaint) {
		super();
		this.status = status;
		this.orderedOn = orderedOn;
		this.amount = amount;
		this.quantity = quantity;
		this.isAccepted = isAccepted;
		this.user = user;
		this.food = food;
		this.complaint = complaint;
	}

	public Order(int id, String status, String orderedOn, float amount, int quantity, String isAccepted, User user,
			Food food, Complaint complaint) {
		super();
		this.id = id;
		this.status = status;
		this.orderedOn = orderedOn;
		this.amount = amount;
		this.quantity = quantity;
		this.isAccepted = isAccepted;
		this.user = user;
		this.food = food;
		this.complaint = complaint;
	}

	public Order(int id, String status, String orderedOn, float amount, int quantity, String isAccepted, User user,
			Food food, Complaint complaint, OrderFeedback orderFeedback) {
		super();
		this.id = id;
		this.status = status;
		this.orderedOn = orderedOn;
		this.amount = amount;
		this.quantity = quantity;
		this.isAccepted = isAccepted;
		this.user = user;
		this.food = food;
		this.complaint = complaint;
		this.orderFeedback = orderFeedback;
	}
	
	
	
	
	
	public Order(int id, String status, String orderedOn, float amount, int quantity, String isAccepted,
			int timeElapsed) {
		super();
		this.id = id;
		this.status = status;
		this.orderedOn = orderedOn;
		this.amount = amount;
		this.quantity = quantity;
		this.isAccepted = isAccepted;
		this.timeElapsed = timeElapsed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTimeElapsed() {
		return timeElapsed;
	}

	public void setTimeElapsed(int timeElapsed) {
		this.timeElapsed = timeElapsed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderedOn() {
		return orderedOn;
	}

	public void setOrderedOn(String orderedOn) {
		this.orderedOn = orderedOn;
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

	public String getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(String isAccepted) {
		this.isAccepted = isAccepted;
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

	public OrderFeedback getOrderFeedback() {
		return orderFeedback;
	}

	public void setOrderFeedback(OrderFeedback orderFeedback) {
		this.orderFeedback = orderFeedback;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", orderedOn=" + orderedOn + ", amount=" + amount
				+ ", quantity=" + quantity + ", isAccepted=" + isAccepted + ", user=" + user + ", food=" + food
				+ ", complaint=" + complaint + ", orderFeedback=" + orderFeedback + "]";
	}

}