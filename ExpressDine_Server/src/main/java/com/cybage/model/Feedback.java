package com.cybage.model;

public class Feedback {

	private int id;
	private String name;
	private String email;
	private int rating;
	private String comment;
	private String feedbackOn;

	public Feedback() {
		super();
	}

	public Feedback(String name, String email, int rating, String comment, String feedbackOn) {
		super();
		this.name = name;
		this.email = email;
		this.rating = rating;
		this.comment = comment;
		this.feedbackOn = feedbackOn;
	}

	public Feedback(int id, String name, String email, int rating, String comment, String feedbackOn) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.rating = rating;
		this.comment = comment;
		this.feedbackOn = feedbackOn;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFeedbackOn() {
		return feedbackOn;
	}

	public void setFeedbackOn(String feedbackOn) {
		this.feedbackOn = feedbackOn;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", name=" + name + ", email=" + email + ", rating=" + rating + ", comment="
				+ comment + ", feedbackOn=" + feedbackOn + "]";
	}

}
