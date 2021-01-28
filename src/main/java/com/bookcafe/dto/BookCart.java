package com.bookcafe.dto;

import org.springframework.stereotype.Component;

@Component
public class BookCart {
	
	private int bookId;
	private int bookQuantity;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	

}
