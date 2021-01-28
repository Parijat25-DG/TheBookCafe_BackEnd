package com.bookcafe.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookcafe.dto.BookCart;
import com.bookcafe.dto.ClassCart;
import com.bookcafe.dto.ClubCart;
import com.bookcafe.dto.ItemCart;
import com.bookcafe.dto.ProductCart;
import com.bookcafe.model.SavedCart;

@Component
public class CartData {
	
	public SavedCart getData(int cardId) {
		SavedCart cart = new SavedCart();
		cart.setCartId(1);
		
		List<BookCart> books = new ArrayList<>();
		BookCart book1 = new BookCart();
		book1.setBookId(301);
		book1.setBookQuantity(1);
		books.add(book1 );
		cart.setBooks(books );
		
		List<ProductCart> products = new ArrayList<>();
		ProductCart product1 = new ProductCart();
		product1.setProductId(102);
		product1.setProductQuantity(1);
		products.add(product1 );
		ProductCart product2 = new ProductCart();
		product2.setProductId(104);
		product2.setProductQuantity(1);
		products.add(product2 );
		cart.setProducts(products );
		
		List<ItemCart> items = new ArrayList<>();
		ItemCart item = new ItemCart();
		item.setItemId(203);
		item.setItemQuantity(2);
		items.add(item );
		cart.setItems(items );
		
		List<ClubCart> clubs = new ArrayList<>();
		ClubCart club = new ClubCart();
		club.setClubId(1002);
		club.setClubQuantity(1);
		clubs.add(club );
		cart.setClubs(clubs );
		
		List<ClassCart> classes = new ArrayList<>();
		ClassCart class1 = new ClassCart();
		class1.setClassId(2003);
		class1.setClassQuantity(2);
		classes.add(class1 );
		cart.setClasses(classes );
		
		return cart;
		
	}

}
