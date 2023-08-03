package sportsportal.beans;

import java.sql.*;
public class ContactBean 
{
	private int id;
	private String name,email,question;
	private String phone;
	private Date date;
	public ContactBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactBean(String name, String email, String question, String phone, Date date) {
		super();
		this.name = name;
		this.email = email;
		this.question = question;
		this.phone = phone;
		this.date = date;
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
