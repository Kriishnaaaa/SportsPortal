package sportsportal.beans;

import java.sql.Date;

public class Member {
	private String id,password,name,email,phone,gender,city,plan_name,address;
	private Date date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Member(String id, String password, String name, String email, String phone, String gender, String city,
			String plan_name, String address, Date date) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.city = city;
		this.plan_name = plan_name;
		this.address = address;
		this.date = date;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String name, String email, String phone, String gender, String city, String plan_name,
			String address, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.city = city;
		this.plan_name = plan_name;
		this.address = address;
		this.date = date;
	}
	public Member(String id, String email, String phone, String city, String address) {
		super();
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.address = address;
	}
	
	

}
