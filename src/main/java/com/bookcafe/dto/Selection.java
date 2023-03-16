package com.bookcafe.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Selection {
	
	private int cartId;
	private List<CartList> cartList;
	private double totalAmt;
	private int paymentMode;
	
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<CartList> getCartList() {
		return cartList;
	}
	public void setCartList(List<CartList> cartList) {
		this.cartList = cartList;
	}
	public int getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(int paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	

}
