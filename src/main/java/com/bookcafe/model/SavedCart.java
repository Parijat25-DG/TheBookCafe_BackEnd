package com.bookcafe.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bookcafe.dto.BookCart;
import com.bookcafe.dto.ClassCart;
import com.bookcafe.dto.ClubCart;
import com.bookcafe.dto.ItemCart;
import com.bookcafe.dto.ProductCart;

@Document(collection="Cart")
public class SavedCart {
	
	@Id
	private int cartId;
	private List<ProductCart> products;
	private List<ItemCart> items;
	private List<BookCart> books;
	private List<ClubCart> clubs;
	private List<ClassCart> classes;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<ProductCart> getProducts() {
		return products;
	}
	public void setProducts(List<ProductCart> products) {
		this.products = products;
	}
	public List<ItemCart> getItems() {
		return items;
	}
	public void setItems(List<ItemCart> items) {
		this.items = items;
	}
	public List<BookCart> getBooks() {
		return books;
	}
	public void setBooks(List<BookCart> books) {
		this.books = books;
	}
	public List<ClubCart> getClubs() {
		return clubs;
	}
	public void setClubs(List<ClubCart> clubs) {
		this.clubs = clubs;
	}
	public List<ClassCart> getClasses() {
		return classes;
	}
	public void setClasses(List<ClassCart> classes) {
		this.classes = classes;
	}
	
	
	

}
