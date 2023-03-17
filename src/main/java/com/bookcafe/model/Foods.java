package com.bookcafe.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Foods")
public class Foods {
	
	@Id
	private ObjectId _id;
	private int foodId;
	private String name;
	private String cuisine;
	private String description;
	private String type;
	private String suitabletime;
	private double price;
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSuitabletime() {
		return suitabletime;
	}
	public void setSuitabletime(String suitabletime) {
		this.suitabletime = suitabletime;
	}
	
}
