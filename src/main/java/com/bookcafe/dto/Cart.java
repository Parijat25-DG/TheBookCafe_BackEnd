package com.bookcafe.dto;

import org.springframework.stereotype.Component;

// incoming at each save
@Component
public class Cart {
	
	private int userId;
	private int cartId;
	private int bookId;
	private int bookQuantity;
	private int productId;
	private int productQuantity;
	private int itemId;
	private int itemQuantity;
	private int clubId;
	private int clubQuantity;
	private int classId;
	private int classQuantity;
	
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public int getClubQuantity() {
		return clubQuantity;
	}
	public void setClubQuantity(int clubQuantity) {
		this.clubQuantity = clubQuantity;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getClassQuantity() {
		return classQuantity;
	}
	public void setClassQuantity(int classQuantity) {
		this.classQuantity = classQuantity;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	

}
