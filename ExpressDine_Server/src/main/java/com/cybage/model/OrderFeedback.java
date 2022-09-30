package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class OrderFeedback {

	@Id
	@GeneratedValue
	private int id;
	private String comment;
	private int rating;
	private String feedbackOn;

	@OneToOne
	private Order order;

	public OrderFeedback(int id, String comment, int rating, String feedbackOn, Order order) {
		super();
		this.id = id;
		this.comment = comment;
		this.rating = rating;
		this.feedbackOn = feedbackOn;
		this.order = order;
	}

	public OrderFeedback() {
		super();
	}

	public OrderFeedback(String comment, int rating, String feedbackOn, Order order) {
		super();
		this.comment = comment;
		this.rating = rating;
		this.feedbackOn = feedbackOn;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedbackOn() {
		return feedbackOn;
	}

	public void setFeedbackOn(String feedbackOn) {
		this.feedbackOn = feedbackOn;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderFeedback [id=" + id + ", comment=" + comment + ", rating=" + rating + ", feedbackOn=" + feedbackOn
				+ ", order=" + order + "]";
	}

}
