package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Complaint {

	@Id
	@GeneratedValue
	private int id;
	private String comment;
	private String status;
	private String commentedOn;
	private String lastReminder;
	private int reminderCount;
	
	
	@OneToOne
	private Order order;

	public Complaint() {
		super();
	}

	public Complaint(int id, String comment, String status, String commentedOn, String lastReminder, int reminderCount,
			Order order) {
		super();
		this.id = id;
		this.comment = comment;
		this.status = status;
		this.commentedOn = commentedOn;
		this.lastReminder = lastReminder;
		this.reminderCount = reminderCount;
		this.order = order;
	}
	
	
	public Complaint(int id, String comment, String status, String commentedOn, String lastReminder,
			int reminderCount) {
		super();
		this.id = id;
		this.comment = comment;
		this.status = status;
		this.commentedOn = commentedOn;
		this.lastReminder = lastReminder;
		this.reminderCount = reminderCount;
	}

	public Complaint(String comment, String status, String commentedOn, String lastReminder, int reminderCount,
			Order order) {
		super();
		this.comment = comment;
		this.status = status;
		this.commentedOn = commentedOn;
		this.lastReminder = lastReminder;
		this.reminderCount = reminderCount;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCommentedOn() {
		return commentedOn;
	}

	public void setCommentedOn(String commentedOn) {
		this.commentedOn = commentedOn;
	}

	public String getLastReminder() {
		return lastReminder;
	}

	public void setLastReminder(String lastReminder) {
		this.lastReminder = lastReminder;
	}

	public int getReminderCount() {
		return reminderCount;
	}

	public void setReminderCount(int reminderCount) {
		this.reminderCount = reminderCount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Complaint [id=" + id + ", comment=" + comment + ", status=" + status + ", commentedOn=" + commentedOn
				+ ", lastReminder=" + lastReminder + ", reminderCount=" + reminderCount + ", order=" + order + "]";
	}

}
