package sportsportal.beans;

import java.sql.*;
public class FeedBackBean 
{
	public FeedBackBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedBackBean(int rating, String name, String email, String feedback, Date date) {
		super();
		this.rating = rating;
		this.name = name;
		this.email = email;
		this.feedback = feedback;
		this.date = date;
	}

	private int id,rating;
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	private String name,email,feedback;
	private Date date;
	private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
