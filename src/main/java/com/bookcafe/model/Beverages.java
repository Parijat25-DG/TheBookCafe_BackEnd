package com.bookcafe.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Beverages")
public class Beverages {
	
	@Id
	private ObjectId _id;
	private int beveragesId;
	private String name;
	private String quality;
	private double price;
	private boolean lactoseFree;
	private String temperature;
	private String suitabletime;
	
	public int getBeveragesId() {
		return beveragesId;
	}
	public void setBeveragesId(int beveragesId) {
		this.beveragesId = beveragesId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isLactoseFree() {
		return lactoseFree;
	}
	public void setLactoseFree(boolean lactoseFree) {
		this.lactoseFree = lactoseFree;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getSuitableTime() {
		return suitabletime;
	}
	public void setSuitableTime(String suitabletime) {
		this.suitabletime = suitabletime;
	}
	
	
		
	

}
