package com.bookcafe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CookingClass")
public class CookingClass {
	
	@Id
	private int classId;
	private String recipeName;
	private String recipeType;
	private String scheduledDate;
	private String seatsAvailable;
	private String suitableFor;
	private String price;
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getRecipeType() {
		return recipeType;
	}
	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}
	public String getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public String getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(String seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public String getSuitableFor() {
		return suitableFor;
	}
	public void setSuitableFor(String suitableFor) {
		this.suitableFor = suitableFor;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	

}
