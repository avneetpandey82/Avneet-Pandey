package com.foodShala.lib.model;

public class Menu {
	private int id;
	private String name;
	private String image;
	private String type;
	private int price;
	
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Menu(int id, String name, String image, String type, int price) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.type = type;
		this.price = price;
	}
	public Menu(String name, String image, String type, int price) {
		this.name = name;
		this.image = image;
		this.type = type;
		this.price = price;
	}
	

}
