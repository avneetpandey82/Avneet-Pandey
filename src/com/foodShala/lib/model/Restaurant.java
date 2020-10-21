package com.foodShala.lib.model;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class Restaurant {
	private int id;
	private String name;
	private String dob;
	private String phone;
	private String address;
	private String gender;
	private String username;
	private String password;
	
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public Restaurant(int id, String name, String dob, String phone, String address, String gender, String username,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	public Restaurant(String name, String dob, String phone, String address, String gender, String username,
			String password) {
		super();
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	
	

}