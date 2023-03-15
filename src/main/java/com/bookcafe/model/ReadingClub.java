package com.bookcafe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ReadingClub")
public class ReadingClub {
	
	@Id
	private int clubId;
	private String bookName;
	private String bookAuthor;
	private String bookGenre;
	private String scheduledDate;
	private String seatsAvailable;
	private String suitableFor;
	private String price;
	
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
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
